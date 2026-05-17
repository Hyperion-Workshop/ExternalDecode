package org.firstinspires.ftc.teamcode.homework.lucas;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;
@Autonomous(name = "square")
public class HW3a extends LinearOpMode {
    DcMotorImplEx dtMotorLF, dtMotorRF, dtMotorLB, dtMotorRB;
    PinpointLocalizer pinpointLocalizer;
    boolean squareCompleted = false;
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
            if (!squareCompleted) { //start position x = 0 , y = 0 , 0 degrees
                setPower(1,1,1,1); //drive forward
                while (pinpointLocalizer.getX() < 48) { //until x is 48
                    continue;
                }
                setPower(-1, -1, 1, 1); //turn right
                while (pinpointLocalizer.getHeading() <= 90) { //until 90 degrees
                    continue;
                }
                setPower(1,1,1,1); //drive forward
                while (pinpointLocalizer.getY() < 48) { //until y is 48
                    continue;
                }
                setPower(-1, -1, 1, 1); //turn right
                while (pinpointLocalizer.getHeading() <= 180) { //until 180 degrees
                    continue;
                }
                setPower(1,1,1,1); //drive forward
                while (pinpointLocalizer.getX() > 0) { //until x is back at 0
                    continue;
                }
                setPower(-1, -1, 1, 1); //turn right
                while (pinpointLocalizer.getHeading() <= 270) { //until 270 degrees
                    continue;
                }
                setPower(1,1,1,1); //drive forward
                while (pinpointLocalizer.getY() > 0) { //until y is back at 0, robot back to x = 0, y = 0
                    continue;
                }
                setPower(-1,-1,1,1); //turn right
                while (pinpointLocalizer.getHeading() <= 0) { //until back at 0 degrees, starting position
                    continue;
                }
                setPower(0,0,0,0);
                squareCompleted = true;
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