package org.firstinspires.ftc.teamcode.homework.lucas;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
public class CW21 extends LinearOpMode {
    DcMotorImplEx dtMotorLF, dtMotorRF, dtMotorLB, dtMotorRB;
    ElapsedTime timer;
    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeInInit()) {
            dtMotorLF = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            dtMotorRF = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            dtMotorLB = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            dtMotorRB = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");
            dtMotorLF.setDirection(DcMotorSimple.Direction.REVERSE);
            dtMotorRF.setDirection(DcMotorSimple.Direction.REVERSE);
            dtMotorLB.setDirection(DcMotorSimple.Direction.FORWARD);
            dtMotorRB.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        waitForStart();
        timer.reset();
        while (opModeIsActive()) {
            if (timer.seconds() <= 2) {
                setPower(1, 1, 1, 1); //drive forward
            }
            else if (timer.seconds() <= 4) {
                setPower(-1,-1,1,1); //turn right
            }
            else if (timer.seconds() <= 6) {
                setPower(1, 1, 1, 1); // drive forward
            }
            else if (timer.seconds() <= 8) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else if (timer.seconds() <= 10) {
                setPower(1,1,1,1); //drive forward
            }
            else if (timer.seconds() <= 12) {
                setPower(-1, -1, 1, 1); //turn right
            }
            else if (timer.seconds() <= 14) {
                setPower(1,1,1,1); //drive forward
            }
            else if (timer.seconds() <= 16) {
                setPower(-1,-1,1,1); //turn right
            }
            else {
                setPower(0,0,0,0); //stop, square complete
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