package org.firstinspires.ftc.teamcode.homework.shane;



import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.logging.ILogger;
import org.firstinspires.ftc.teamcode.state.BaseIOStateMachine;

public class HW5a extends BaseIOStateMachine {
    DcMotorImplEx motor;

    public HW5a(ILogger logger) {
        super(logger);
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    public void initHw(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorImplEx.class, "intake.motor");
    }

    public enum State {
        IDLE, STATE
    }
}
