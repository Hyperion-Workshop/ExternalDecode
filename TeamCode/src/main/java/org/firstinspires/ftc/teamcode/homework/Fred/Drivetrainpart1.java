package org.firstinspires.ftc.teamcode.homework.Fred;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Drivetrainpart1 extends LinearOpMode {
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
            if (timer.seconds() > forwardTime+turnTime) {
                timer.reset();
            } else if (timer.seconds()<=forwardTime) {
                setPowers(1,1,1,1);
            } else {
                setPowers(1,1,-1,-1);
            }
        }
    }
}
