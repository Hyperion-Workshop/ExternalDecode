package org.firstinspires.ftc.teamcode.state;

import org.firstinspires.ftc.teamcode.logging.ILogger;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStateMachine<T extends Enum<T>> {
  public ILogger logger;
  private T prevState;
  private T currentState;
  private T nextState;
  private boolean hasLateInited = false;

  private boolean currentlyUpdating = false;
  private int stateChanges = 0;

  protected final String className;

  // TODO: telemetry display for states?
  private final Set<String> hasStarted;
  private final Set<String> isDone;

  public AbstractStateMachine(ILogger logger) {
    this.logger = logger;
    className = this.getClass().getSimpleName();
    hasStarted = new HashSet<>();
    isDone = new HashSet<>();
    init();
  }

  /**
   * Initialize subclass behavior here, such as initial state.
   */
  protected abstract void init();

  /**
   * Initialize behavior that depends on config options.
   */
  protected void lateInit() {
  }

  /**
   * The method that subclasses should implement behavior in.
   */
  protected abstract void tick();

  public void update() {
    if (!hasLateInited) {
      lateInit();
      hasLateInited = true;
    }

    //logger.i(className, "update() with state = " + getCurrentState());
    if (currentState == null) throw new RuntimeException(className + ": state is null");

    stateChanges = 0;
    currentlyUpdating = true;

    try {
      tick();
    } finally {
      if (currentState != nextState) {
        onSwitchState();
      }
      currentlyUpdating = false;
    }
  }

  protected void onSwitchState() {
    logger.i(className, "Switching states from " + currentState + " to " + nextState);
    prevState = currentState;
    currentState = nextState;
    hasStarted.clear();
    isDone.clear();
  }

  public T getCurrentState() {
    return currentState;
  }

  public T getPrevState() {
    return prevState;
  }

  /**
   * Returns if the state was changed during the current cycle.
   */
  public boolean stateChanged() {
    if (!currentlyUpdating)
      throw new RuntimeException(className + ": queried stateChanged() outside of tick()");

    return stateChanges != 0;
  }

  public void __switchStateTypeUnsafeDoNotUse(Enum<?> state) {
    switchState((T)state);
  }

  /**
   * Switch to the next state. Non-Op if current state is already target state.
   */
  public void switchState(T state) {
    if (state == null) throw new RuntimeException(className + ": tried to switch to null state");

    if (state == currentState && state == nextState) {
      logger.i(className, "Ignoring switchState request due to already being in the " + state + " state");
      return;
    }

    if (currentlyUpdating) {
      if (stateChanges != 0) {
        logger.w(className, "Multiple state changes in one update cycle; replacing " + nextState + " with " + state);
      }

      // Queue the state change, but don't change it yet
      nextState = state;
      stateChanges++;
    } else {
      // State was changed by code outside of tick()
      nextState = state;
      onSwitchState();
    }
  }

  /**
   * Immediately switch to a different state, overwriting the current one and any previous switchState calls.
   * Avoid using this method whenever possible.
   */
  protected void unsafeSwitchStateImmediate(T state) {
    nextState = state;
    onSwitchState();
  }

  protected boolean hasLateInitRun() {
    return hasLateInited;
  }

  // Immediate mode style helper functions

  // Used internally in _c and conditions
  private static final byte START_MASK = 0b01;
  private static final byte END_MASK = 0b10;

  /**
   * Handle a step within a state of the state machine.
   * <p>
   * Example:
   * if (_c("my step", runOnce(), afterEnd("prev step"), until(i > 3))) {
   * i++;
   * }
   *
   * @param name       Name of the step.
   * @param conditions Conditions for that step to run.
   * @return Whether to run the step during this cycle
   */
  protected final boolean _c(String name, byte... conditions) {
    if (isDone.contains(name)) return false;

    boolean justStarted = false;

    if (!hasStarted.contains(name)) {
      boolean shouldStart = true; // all start conditions must be met to start
      for (byte result : conditions) {
        if ((result & START_MASK) == 0) {
          shouldStart = false;
          break;
        }
      }

      if (!shouldStart) return false;
      hasStarted.add(name);
      justStarted = true;
    }

    boolean shouldEnd = false; // any end condition can be met to stop
    for (byte result : conditions) {
      if ((result & END_MASK) != 0) {
        shouldEnd = true;
        break;
      }
    }

    if (shouldEnd) {
      isDone.add(name);

      // anything that has just started must be run for at least one loop
      return justStarted;
    }

    return true;
  }

  protected byte runOnce() {
    return START_MASK | END_MASK;
  }

  protected byte afterStart(String after) {
    return hasStarted.contains(after) ? START_MASK : 0;
  }

  protected byte afterEnd(String after) {
    return isDone.contains(after) ? START_MASK : 0;
  }

  protected byte afterCondition(boolean condition) {
    return condition ? START_MASK : 0;
  }

  protected byte until(boolean condition) {
    return (byte) (START_MASK | (condition ? END_MASK : 0));
  }
}
