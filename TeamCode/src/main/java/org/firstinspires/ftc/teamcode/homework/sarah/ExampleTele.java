package org.firstinspires.ftc.teamcode.homework.sarah;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.hyperionModules.HyperionTelemetry;
import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;

@TeleOp(name="SampleTele")
public class ExampleTele extends LinearOpMode {
  DcMotorImplEx motorLf, motorLb, motorRf, motorRb;
  HyperionTelemetry hyperionTelemetry;
  PinpointLocalizer localizer;
  @Override
  public void runOpMode() throws InterruptedException {
    double strafe, drive, turn;
    while (opModeInInit()) {
      motorLf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
      motorLb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
      motorRf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
      motorRb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");

      motorRf.setDirection(DcMotorSimple.Direction.REVERSE);
      motorRb.setDirection(DcMotorSimple.Direction.REVERSE);
      motorLf.setDirection(DcMotorSimple.Direction.FORWARD);
      motorLb.setDirection(DcMotorSimple.Direction.FORWARD);

      hyperionTelemetry = new HyperionTelemetry(telemetry);
      localizer = new PinpointLocalizer(hardwareMap);
    }
    waitForStart();
    while (opModeIsActive()) {
      strafe = gamepad1.left_stick_x;
      turn = gamepad1.right_stick_x;
      drive = gamepad1.left_stick_y;

      motorLf.setPower(drive - turn - strafe);
      motorLb.setPower(drive - turn + strafe);
      motorRf.setPower(drive + turn + strafe);
      motorRb.setPower(drive + turn - strafe);

      hyperionTelemetry.addData("strafe", strafe);
      hyperionTelemetry.addData("turn", turn);
      hyperionTelemetry.addData("drive", drive);

      hyperionTelemetry.addData("x", localizer.getX());
      hyperionTelemetry.addData("y", localizer.getY());
      hyperionTelemetry.update();
    }
  }
}
