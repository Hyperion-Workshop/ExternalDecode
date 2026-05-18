package org.firstinspires.ftc.teamcode.homework.lucas;

import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.logging.ILogger;
import org.firstinspires.ftc.teamcode.state.BaseIOStateMachine;

public class Intake extends BaseIOStateMachine<Intake.State> {
    DcMotorImplEx motor;
    public Intake(ILogger logger) {
        super(logger);
    }

    @Override
    protected void init() {
        switchState(State.IDLE);
    }

    @Override
    protected void tick() {
        switch (getCurrentState()) {
            case IDLE:
                motor.setPower(0);
                setStateChangeReadiness(switchToQueued());
                break;
            case ACTIVE:
                motor.setPower(1);
                setStateChangeReadiness(switchToQueued());
                break;
        }
    }
    public void initHw(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorImplEx.class, "intake.motor");
    }
    public enum State {
        IDLE,
        ACTIVE
    }
}
