package org.firstinspires.ftc.teamcode.homework.sarah;

import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Calc;
import org.firstinspires.ftc.teamcode.logging.ILogger;
import org.firstinspires.ftc.teamcode.pid.PIDF;
import org.firstinspires.ftc.teamcode.state.BaseIOStateMachine;

public class ExampleStateMachine extends BaseIOStateMachine<ExampleStateMachine.State> {
  public static double P = 0, I = 0, D = 0, F = 0;
  public static double target = 0, error = 0;

  DcMotorImplEx motor;
  PIDF pidf = new PIDF(P,I,D,F);
  ElapsedTime timer;

  public ExampleStateMachine(ILogger logger) {
    super(logger);
  }

  // pretend method
  double getAngularVelocity() {
    return 1;
  }

  @Override
  protected void init() {
    switchState(State.IDLE);
  }

  // runs every loop
  @Override
  protected void tick() {
    switch(getCurrentState()) {
      case IDLE :
        // do stuff
        break;
      case ACTIVE:
        // do stuff

        // error + power calculations
        error = target - getAngularVelocity();
        double power = pidf.update(timer.milliseconds()).calc(error);
        break;
    }
    timer.reset();
  }

  // hardware map stuff
  public void initHw(HardwareMap hardwareMap) {
    motor = hardwareMap.get(DcMotorImplEx.class, "motor.name");
  }

  public enum State {
    IDLE, ACTIVE
  }
}
