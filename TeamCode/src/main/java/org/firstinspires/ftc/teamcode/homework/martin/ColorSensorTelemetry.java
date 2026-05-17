package org.firstinspires.ftc.teamcode.homework.martin;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hyperionModules.HyperionColorSensor;
import org.firstinspires.ftc.teamcode.hyperionModules.HyperionTelemetry;

import java.util.Arrays;

public class ColorSensorTelemetry extends OpMode {
    HyperionTelemetry telemetry;
    HyperionColorSensor colorSensor;

    @Override
    public void init() {
        colorSensor = new HyperionColorSensor(hardwareMap, "colorSensor");
    }

    @Override
    public void loop() {
        telemetry.addLine(Arrays.toString(colorSensor.getRGBValues()));
        telemetry.update();
    }
}
