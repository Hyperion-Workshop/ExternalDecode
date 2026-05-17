package org.firstinspires.ftc.teamcode.homework.Fred;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;


public class HW3Part1 extends LinearOpMode {
    DcMotorImplEx motorlb;
    DcMotorImplEx motorlf;
    DcMotorImplEx motorrb;
    DcMotorImplEx motorrf;
    ElapsedTime timer;

    PinpointLocalizer localizer;
    int forwardTime=4;
    int turnTime;

    int degrees=90;
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
            motorrb.setDirection(DcMotorSimple.Direction.FORWARD);
            motorrf.setDirection(DcMotorSimple.Direction.FORWARD);
            localizer = new PinpointLocalizer(hardwareMap);
        }
        waitForStart();
        while (opModeIsActive()) {
            /*
            go forward for X seconds
            when X seconds are over, turn
                while heading (in degrees) % 90 != 0 then powers (-1, -1, 1, 1)
            reset timer
             */
            if (turnTime<4) {
                localizer.update();
                if(timer.seconds() <= forwardTime) {
                    setPowers(1,1,1,1);
                }else if(localizer.pinpoint.getHeading(AngleUnit.DEGREES) < degrees){
                    setPowers(1,1,-1,-1);
                } else {
                    timer.reset();
                    turnTime += 1;
                    setPowers(0,0,0,0);
                    degrees += 90;
                }
            }
        }
    }
}

