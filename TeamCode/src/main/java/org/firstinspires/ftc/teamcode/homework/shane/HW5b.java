package org.firstinspires.ftc.teamcode.homework.shane;

import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.logging.ILogger;
import org.firstinspires.ftc.teamcode.pid.PIDF;
import org.firstinspires.ftc.teamcode.state.BaseIOStateMachine;

public class HW5b extends BaseIOStateMachine<HW5b.State> {
    DcMotorImplEx motor;
    public static double P = 0, I = 0, D = 0, F = 0;
    public static double target = 0, error = 0;
    ElapsedTime timer = new ElapsedTime();


    PIDF pidf = new PIDF(P,I,D,F);
    public HW5b(ILogger logger) {
        super(logger);
    }

    double getAngularVelocity() {
        return 1;
    }

    @Override
    protected void init() {
        switchState(HW5b.State.IDLE);
    }

    @Override
    protected void tick() {
        switch(getCurrentState()) {
            case IDLE:
                motor.setPower(0);
                setStateChangeReadiness(!switchToQueued());
                break;
            case ACTIVE:
                error = target - getAngularVelocity();
                double power = pidf.update(timer.milliseconds()).calc(error);
                break;
        }
        timer.reset();
    }

    public void initHw(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorImplEx.class, "shooer.motor"); //with a t btw
    }

    public enum State {
        IDLE, ACTIVE
    }

}
