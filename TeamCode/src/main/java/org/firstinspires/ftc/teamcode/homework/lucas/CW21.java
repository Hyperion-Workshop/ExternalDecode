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
            dtMotorLF = hardwareMap.get(DcMotorImplEx.class, "dt.Motor.LF");
            dtMotorRF = hardwareMap.get(DcMotorImplEx.class, "dt.Motor.RF");
            dtMotorLB = hardwareMap.get(DcMotorImplEx.class, "dt.Motor.LB");
            dtMotorRB = hardwareMap.get(DcMotorImplEx.class, "dt.Motor.RB");
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
            if (timer.seconds() <= 4) {
                setPower(-1,-1,1,1); //turn right
            }
            if (timer.seconds() <= 6) {
                setPower(1, 1, 1, 1); // drive forward
            }
            if (timer.seconds() <= 8) {
                setPower(-1, -1, 1, 1); //turn right
            }
            if (timer.seconds() <= 10) {
                setPower(1,1,1,1); //drive forward
            }
            if (timer.seconds() <= 12) {
                setPower(-1, -1, 1, 1); //turn right
            }
            if (timer.seconds() <= 14) {
                setPower(1,1,1,1); //drive forward
            }
            if (timer.seconds() <= 16) {
                setPower(-1,-1,1,1); //turn right, square complete
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