package org.firstinspires.ftc.teamcode.homework.martin;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class CW21LinearOpMode extends LinearOpMode {
    DcMotorImplEx lf;
    DcMotorImplEx rf;
    DcMotorImplEx lb;
    DcMotorImplEx rb;
    ElapsedTime timer;

    int loops;
    double straightTime = 5;
    double turnTime = 1;

    @Override
    public void runOpMode() throws InterruptedException {
        while(opModeInInit()){
            lf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            rf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            lb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            rb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");
            lf.setDirection(DcMotorSimple.Direction.REVERSE);
            lb.setDirection(DcMotorSimple.Direction.REVERSE);
            rf.setDirection(DcMotorSimple.Direction.FORWARD);
            rb.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        waitForStart();
        while(opModeIsActive()){
            if(timer.seconds() <= straightTime && loops < 4) {
                lf.setPower(1);
                lb.setPower(1);
                rf.setPower(1);
                rb.setPower(1);
            }else if(timer.seconds() <= straightTime+turnTime && loops < 4){
                lf.setPower(1);
                lb.setPower(1);
                rf.setPower(-1);
                rb.setPower(-1);
            }else{
                timer.reset();
                loops += 1;
                lf.setPower(0);
                lb.setPower(0);
                rf.setPower(0);
                rb.setPower(0);
            }
        }
    }
}
