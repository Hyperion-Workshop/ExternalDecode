package org.firstinspires.ftc.teamcode.homework.martin;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;

public class CWLinearOpModeWithHeading extends LinearOpMode {
    DcMotorImplEx lf;
    DcMotorImplEx rf;
    DcMotorImplEx lb;
    DcMotorImplEx rb;
    ElapsedTime timer;
    PinpointLocalizer localizer;

    double straightTime = 5;
    int loops;
    double targetHeading = 90;

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

            localizer = new PinpointLocalizer(hardwareMap);

        }
        waitForStart();
        while(opModeIsActive()){
            if(loops<4){
                localizer.update();
                if(timer.seconds() <= straightTime) {
                    lf.setPower(1);
                    lb.setPower(1);
                    rf.setPower(1);
                    rb.setPower(1);
                }else if(localizer.pinpoint.getHeading(AngleUnit.DEGREES) < targetHeading){
                    lf.setPower(1);
                    lb.setPower(1);
                    rf.setPower(-1);
                    rb.setPower(-1);
                }else {
                    timer.reset();
                    loops += 1;
                    lf.setPower(0);
                    lb.setPower(0);
                    rf.setPower(0);
                    rb.setPower(0);
                    targetHeading += 90;
                }
            }
        }
    }
}
