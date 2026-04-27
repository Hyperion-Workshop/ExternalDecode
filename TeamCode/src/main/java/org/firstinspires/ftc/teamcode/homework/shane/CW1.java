package org.firstinspires.ftc.teamcode.homework.shane;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/* Program dt to go in 48 x 48 square
class called CW21 LinearOpMode

4 motors; Dt.motor.lf, Dt.motor.rf, Dt.motor.lb, Dt.motor.rb

left motors REVERSE, right motors FORWARD
robot drive forward for X seconds, turn right, drive forward, etc.
Time-based controls
*/
public class CW1 extends LinearOpMode {
    DcMotorImplEx motorlf;
    DcMotorImplEx motorlb;
    DcMotorImplEx motorrf;
    DcMotorImplEx motorrb;
    ElapsedTime noble;
    int forwardTime = 4; //change for time while going forward
    int turnTime = 4; //change for time while turning

    public void setPowers(double lf, double lb, double rf, double rb) {
        motorlf.setPower(lf);
        motorlb.setPower(lb);
        motorrf.setPower(rf);
        motorrb.setPower(rb);

    }

    @Override
    public void runOpMode() throws InterruptedException {
        //declare variables

        while (opModeInInit()) {
            //init
            motorlf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            motorlb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            motorrf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            motorrb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");

            motorlf.setDirection(DcMotorSimple.Direction.REVERSE);
            motorlb.setDirection(DcMotorSimple.Direction.REVERSE);
            motorrf.setDirection(DcMotorSimple.Direction.FORWARD);
            motorrb.setDirection(DcMotorSimple.Direction.FORWARD);


        }
        waitForStart();

        while (opModeIsActive()) {
            // code
            if (noble.seconds() > forwardTime + turnTime) {
                noble.reset();
            } else if (noble.seconds() <= forwardTime) {
                setPowers(1, 1, 1, 1);
            } else {
                setPowers(1, 1, -1, -1);
            }



        }
    }
}
