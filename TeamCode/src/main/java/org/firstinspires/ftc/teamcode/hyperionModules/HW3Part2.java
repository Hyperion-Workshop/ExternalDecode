package org.firstinspires.ftc.teamcode.hyperionModules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class HW3Part2 extends OpMode {
    NormalizedColorSensor colorSensor;

    Telemetry telemetry;

    public float red() {
        return colorSensor.getNormalizedColors().red;
    }

    public float green() {

        return colorSensor.getNormalizedColors().green;
    }

    public float blue() {

        return colorSensor.getNormalizedColors().blue;
    }
    public void colors() {
        telemetry.addData("red",red());
        telemetry.addData("blue",blue());
        telemetry.addData("green",green());
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        colors();
    }

}



