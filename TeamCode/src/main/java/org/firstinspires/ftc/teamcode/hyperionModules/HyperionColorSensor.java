package org.firstinspires.ftc.teamcode.hyperionModules;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

public class HyperionColorSensor {
    NormalizedColorSensor colorSensor;
    // rgb
    final float[] ARTIFACT_LOW = {0.0015f, 0.0015f, 0.0015f};
    final float[] G_LOW = {0.0015f, 0.0015f, 0.0015f};
    final float[] G_HIGH = {0.0015f, 0.0015f, 0.0015f};
    final float[] P_LOW = {0.0015f, 0.0015f, 0.0015f};
    final float[] P_HIGH = {0.0015f, 0.0015f, 0.0015f};

    public HyperionColorSensor(HardwareMap hardwareMap, String name) {
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, name);
    }

    public float red() {
        return colorSensor.getNormalizedColors().red;
    }

    public float green() {
        return colorSensor.getNormalizedColors().green;
    }

    public float blue() {
        return colorSensor.getNormalizedColors().blue;
    }

    public float[] getRGBValues() {
        return new float[] {red(), green(), blue()};
    }

    public boolean greaterThanRGBValues(float r, float g, float b) {
        if (red() > r && green() > g && blue() > b) return true;
        else return false;
    }

    public boolean greaterThanRGBValues(float[] rgb) {
        if (red() > rgb[0] && green() > rgb[1] && blue() > rgb[2]) return true;
        else return false;
    }

    public boolean lessThanRGBValues(float r, float g, float b) {
        if (red() < r && green() < g && blue() < b) return true;
        else return false;
    }

    public boolean lessThanRGBValues(float[] rgb) {
        if (red() < rgb[0] && green() < rgb[1] && blue() < rgb[2]) return true;
        else return false;
    }

    public boolean betweenRGBValues(float[] low, float[] high) {
        if (greaterThanRGBValues(low) && lessThanRGBValues(high)) return true;
        return false;
    }

    public boolean getArtifactPresent() {
        return (greaterThanRGBValues(ARTIFACT_LOW));
    }

    public char getArtifactColor() {
        if (betweenRGBValues(G_LOW, G_HIGH)) return 'g';
        if (betweenRGBValues(P_LOW, P_HIGH)) return 'p';
        else return 'x';
    }

    public void initHw(HardwareMap hardwareMap, String name) {
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, name);
    }

}
