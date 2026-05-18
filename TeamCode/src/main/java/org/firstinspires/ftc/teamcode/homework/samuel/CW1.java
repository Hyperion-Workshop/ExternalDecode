package org.firstinspires.ftc.teamcode.homework.samuel;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class CW21 extends LinearOpMode {

    DcMotorImplEx motor; 
    DcMotorImplEx Dtmotorlf,Dtmotorrf,Dtmotorrb,Dtmotorlb;


    @Override
    public void runOpMode() throws InterruptedException{
        while (opModeInInit()){

        }
        waitForStart();
        while (opModeIsActive()){

        }
    }


    @Override
    public void init() {
        motor = hardwareMap.get(DcMotorImplEx.class, "motor.name");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }


}
Set motors to forward
to strafe  front motors turn back and back motors turn forward

To turn left set left motors to forward and left motors to back