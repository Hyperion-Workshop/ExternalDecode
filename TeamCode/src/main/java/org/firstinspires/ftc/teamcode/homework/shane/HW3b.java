package org.firstinspires.ftc.teamcode.homework.shane;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hyperionModules.HyperionTelemetry;

public class HW3b extends OpMode {
    NormalizedColorSensor colorSensor;
    Telemetry telemetry;
    HyperionTelemetry hyperionTelemetry;

    hyperionTelemetry = new HyperionTelemetry(telemetry);
    public float red() {
        return colorSensor.getNormalizedColors().red;
    }

    public float green() {
        return colorSensor.getNormalizedColors().green;
    }

    public float blue() {
        return colorSensor.getNormalizedColors().blue;
    }
    public void printColors() {
        // use telemetry to print out color sensor values
        telemetry.addData("red", red());
        telemetry.addData("green", green());
        telemetry.addData("blue", blue());
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        printColors();
    }

}
