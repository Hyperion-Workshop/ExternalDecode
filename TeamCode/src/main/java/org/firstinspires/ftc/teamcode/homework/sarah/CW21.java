package org.firstinspires.ftc.teamcode.homework.sarah;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Controls;

public class CW21 extends LinearOpMode {
  Controls c;
  DcMotorImplEx dtMotorLF, asdfj;
  ElapsedTime timer;

  @Override
  public void runOpMode() throws InterruptedException {
    while (opModeInInit()) {
      c = new Controls(gamepad1);
      dtMotorLF = hardwareMap.get(DcMotorImplEx.class, "dt.motor.LF");
    }
    waitForStart();
    while (opModeIsActive()) {
      dtMotorLF.setPower(1);
      timer.reset();
      if (c.ly > 0) {
      } else {
        dtMotorLF.setPower(0);
      }
      if (timer.milliseconds() > 5000) {

      }
    }
  }
}
