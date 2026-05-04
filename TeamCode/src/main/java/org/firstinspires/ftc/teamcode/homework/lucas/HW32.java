package org.firstinspires.ftc.teamcode.homework.lucas;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hyperionModules.HyperionColorSensor;
import org.firstinspires.ftc.teamcode.hyperionModules.HyperionTelemetry;

@Autonomous(name = "color sensor")
public class HW32 extends LinearOpMode{
    HyperionColorSensor hyperionColorSensor;
    HyperionTelemetry hyperionTelemetry;

    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeInInit()) {
            hyperionColorSensor = new HyperionColorSensor(hardwareMap, "colorSensor");
            hyperionTelemetry = new HyperionTelemetry(telemetry);
        }
        while (opModeIsActive()) {
            hyperionTelemetry.addData("RGB Values: " , hyperionColorSensor.getRGBValues());
            hyperionTelemetry.addData("Artifact Color: " , hyperionColorSensor.getArtifactColor());
        }
    }
}