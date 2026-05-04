package org.firstinspires.ftc.teamcode.homework.lucas;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;
@Autonomous(name = "square")
public class HW31 extends LinearOpMode {
    DcMotorImplEx dtMotorLF, dtMotorRF, dtMotorLB, dtMotorRB;
    PinpointLocalizer pinpointLocalizer;

    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeInInit()) {
            dtMotorLF = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            dtMotorRF = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            dtMotorLB = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            dtMotorRB = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");
            dtMotorLF.setDirection(DcMotorSimple.Direction.REVERSE);
            dtMotorRF.setDirection(DcMotorSimple.Direction.FORWARD);
            dtMotorLB.setDirection(DcMotorSimple.Direction.REVERSE);
            dtMotorRB.setDirection(DcMotorSimple.Direction.FORWARD);
            pinpointLocalizer = new PinpointLocalizer(hardwareMap);
        }
        waitForStart();
        while (opModeIsActive()) {
            if (pinpointLocalizer.getX() < 48) {
                setPower(1,1,1,1); //drive forward
            }
            else if (pinpointLocalizer.getHeading() <= 90) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else if (pinpointLocalizer.getY() < 48) {
                setPower(1,1,1,1); //drive forward
            }
            else if (pinpointLocalizer.getHeading() <= 180) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else if (pinpointLocalizer.getX() > 0) {
                setPower(1,1,1,1); //drive forward
            }
            else if (pinpointLocalizer.getHeading() <= 270) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else if (pinpointLocalizer.getY() > 0) {
                setPower(1,1,1,1); //drive forward
            }
            else if (pinpointLocalizer.getHeading() <= 0) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else {
                setPower(0,0,0,0);
            }
        }
    }
    public void setPower(double lfPower, double lbPower, double rfPower, double rbPower) {
        dtMotorLF.setPower(lfPower);
        dtMotorLB.setPower(lbPower);
        dtMotorRF.setPower(rfPower);
        dtMotorRB.setPower(rbPower);
    }
}