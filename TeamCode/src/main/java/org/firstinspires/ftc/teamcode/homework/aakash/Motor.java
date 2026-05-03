package org.firstinspires.ftc.teamcode.homework.aakash;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Drive in a Square")
public class Motor extends OpMode {

    DcMotorImplEx Dtmotorlf, Dtmotorrf, Dtmotorlb, Dtmotorrb;
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {
        Dtmotorlf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
        Dtmotorrf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
        Dtmotorlb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
        Dtmotorrb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");

        Dtmotorlf.setDirection(DcMotorSimple.Direction.REVERSE);
        Dtmotorlb.setDirection(DcMotorSimple.Direction.REVERSE);

        Dtmotorrf.setDirection(DcMotorSimple.Direction.FORWARD);
        Dtmotorrb.setDirection(DcMotorSimple.Direction.FORWARD);

        Dtmotorlf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Dtmotorrf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Dtmotorlb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Dtmotorrb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        timer.reset();
    }

    @Override
    public void loop() {
        double time = timer.seconds();

        //  DRIVE in a square
        if (time < 2.0) {                 // GOing foward
            setmotorpower(0.5, 0.5, 0.5, 0.5);
        }
        else if (time < 2.8) {            // Turn right
            setmotorpower(0.5, -0.5, 0.5, -0.5);
        }
        else if (time < 4.8) {            // Forward
            setmotorpower(0.5, 0.5, 0.5, 0.5);
        }
        else if (time < 5.6) {            // Turn right
            setmotorpower(0.5, -0.5, 0.5, -0.5);
        }
        else if (time < 7.6) {            // Forward
            setmotorpower(0.5, 0.5, 0.5, 0.5);
        }
        else if (time < 8.4) {            // Turn right
            setmotorpower(0.5, -0.5, 0.5, -0.5);
        }
        else if (time < 10.4) {           //Another Forward
            setmotorpower(0.5, 0.5, 0.5, 0.5);
        }
        else if (time < 11.2) {           // Final turn
            setmotorpower(0.5, -0.5, 0.5, -0.5);
        }
        else {        // Stop the robot motor
            setmotorpower(0, 0, 0, 0);
        }
    }

    public void setmotorpower(double lf, double rf, double lb, double rb) {
        Dtmotorlf.setPower(lf);
        Dtmotorrf.setPower(rf);
        Dtmotorlb.setPower(lb);
        Dtmotorrb.setPower(rb);
    }
}