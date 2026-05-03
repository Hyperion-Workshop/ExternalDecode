package org.firstinspires.ftc.teamcode.hyperionModules;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.UnnormalizedAngleUnit;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;


public class PinpointLocalizer {
    private static boolean hasInitialized = false;

    public GoBildaPinpointDriver pinpoint;

    public PinpointLocalizer(HardwareMap hardwareMap) {
        this(hardwareMap, ResetMode.IF_UNINITIALIZED);
    }

    public PinpointLocalizer(HardwareMap hardwareMap, ResetMode resetPosAndIMU) {
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        // https://github.com/goBILDA-Official/FtcRobotController-Add-Pinpoint/tree/goBILDA-Odometry-Driver

        // millimeters from center of rotation
        // x is how far sideways the forwards pod is (left of center is positive)
        // y is how far forwards the strafe pod is (front of center is positive)

        pinpoint.setOffsets(177.8, 44.45);

        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        // left/forward is FORWARD
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);

        // must be stationary when this is called
        if (resetPosAndIMU == ResetMode.YES || (resetPosAndIMU == ResetMode.IF_UNINITIALIZED && !hasInitialized)) {
            pinpoint.resetPosAndIMU();
            hasInitialized = true;

            try {
                // allow it to finish initializing before performing other actions, such as setting current pose
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException("Unexpected interrupt", e);
            }
        }
    }

    public void update() {
        pinpoint.update();
    }

    public double getX() {
        return pinpoint.getPosX();
    }

    public double getY() {
        return pinpoint.getPosY();
    }

    public enum ResetMode {
        YES,
        NO,
        IF_UNINITIALIZED,
    }
}
