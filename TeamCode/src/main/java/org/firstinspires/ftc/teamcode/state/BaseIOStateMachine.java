package org.firstinspires.ftc.teamcode.state;

import org.firstinspires.ftc.teamcode.logging.ILogger;

public abstract class BaseIOStateMachine<T extends Enum<T>> extends AbstractStateMachine<T> {
  T queuedState;

  private boolean readyForStateChange;

  public BaseIOStateMachine(ILogger logger) {
    super(logger);
  }

    protected BaseIOStateMachine() {
    }

    protected void onSwitchState() {
    super.onSwitchState();
    readyForStateChange = false;
  }

  public boolean isReadyForStateChange() {
    return readyForStateChange;
  }

  protected void setStateChangeReadiness(boolean to) {
    readyForStateChange = to;
  }

  public void queueNextState(T state) {
    queuedState = state;
  }

  public boolean hasQueuedState() {
    return queuedState != null;
  }

  /**
   * Either switches to the specified state immediately or queues it.
   * @return Whether the state was queued.
   */
  public boolean scheduleSwitchOrQueue(T state) {
    if (isReadyForStateChange()) {
      switchState(state);
      return false;
    } else {
      queueNextState(state);
      return true;
    }
  }

  /**
   * Switch to the queued state (if any). Otherwise switches to the specific state.
   *
   * @param state State to switch to if there is nothing queued.
   * @return true if there was a queued state that we switched to.
   */
  protected boolean switchToQueuedOr(T state) {
    if (queuedState != null) {
      switchState(queuedState);
      queuedState = null;

      return true;
    } else {
      switchState(state);

      return false;
    }
  }

  /**
   * Switch to the queued state (if any).
   */
  protected boolean switchToQueued() {
    if (queuedState != null) {
      switchState(queuedState);
      queuedState = null;

      return true;
    } else {
      return false;
    }
  }

  protected T getQueuedState() {
    return queuedState;
  }

  protected void clearQueuedState() {
    queuedState = null;
  }
}
