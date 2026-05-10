package org.firstinspires.ftc.teamcode.homework.Fred;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Controls;

public class Drivetrainpart2 extends LinearOpMode {
    Controls c;
    DcMotorImplEx motorlb;
    DcMotorImplEx motorlf;
    DcMotorImplEx motorrb;
    DcMotorImplEx motorrf;
    ElapsedTime timer;
    int forwardTime=4;
    int turnTime=4;
    public void setPowers(double lf, double lb, double rb, double rf) {
        motorlf.setPower(lf);
        motorlb.setPower(lb);
        motorrb.setPower(rb);
        motorrf.setPower(rf);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeInInit()) {
            c=new Controls(gamepad1);
            motorlb=hardwareMap.get(DcMotorImplEx.class, "motor.name");
            motorlf=hardwareMap.get(DcMotorImplEx.class, "motor.name");
            motorrb=hardwareMap.get(DcMotorImplEx.class, "motor.name");
            motorrf=hardwareMap.get(DcMotorImplEx.class, "motor.name");
            motorlb.setDirection(DcMotorSimple.Direction.REVERSE);
            motorlf.setDirection(DcMotorSimple.Direction.REVERSE);
            motorrb.setDirection(DcMotorSimple.Direction.REVERSE);
            motorrf.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        waitForStart();
        while (opModeIsActive()) {
            if (c.ly>0) {
                setPowers(1,1,1,1);
            } else {
                setPowers(1,1,-1,-1);
            }
        }
    }
}