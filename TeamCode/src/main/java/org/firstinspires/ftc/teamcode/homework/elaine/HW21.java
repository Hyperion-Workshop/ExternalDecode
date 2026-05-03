package org.firstinspires.ftc.teamcode.homework.elaine;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
public class HW21 extends LinearOpMode {
    DcMotorImplEx motorLf, motorLb, motorRf, motorRb;
    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime timer = new ElapsedTime();
        while (opModeInInit()) {
            motorLf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            motorLf.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            motorLb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            motorLb.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            motorRf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            motorRf.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            motorRb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");
            motorRb.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
        waitForStart();
        while (opModeIsActive()){
            if (timer.seconds() >= 46) {
                timer.reset();
                setMotorPower(0,0,0,0);
            }
            if (timer.seconds() < 10) {
                setMotorPower (1,1,1,1);
            }
            else if (timer.seconds() < 12) {
                setMotorPower (-1, 1, 1, -1);
            }
            else if (timer.seconds() < 22) {
                setMotorPower (1,1,1,1);
            }
            else if (timer.seconds() < 24) {
                setMotorPower(-1,1,1,-1);
            }
            else if(timer.seconds() < 34) {
                setMotorPower(1,1,1,1);
            }
            else if(timer.seconds() < 36) {
                setMotorPower(-1,1,1,-1);
            }
            else if(timer.seconds() < 46) {
                setMotorPower(1,1,1,1);
            }
        }
    }
    public void setMotorPower (double Lf, double Rf, double Rb, double Lb) {
        motorLf.setPower(Lf);
        motorRf.setPower(Rf);
        motorRb.setPower(Rb);
        motorLb.setPower(Lb);
    }
}