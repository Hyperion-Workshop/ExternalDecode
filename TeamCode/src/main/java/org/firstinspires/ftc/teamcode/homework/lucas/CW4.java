package org.firstinspires.ftc.teamcode.homework.lucas;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;

public class CW4 extends OpMode {
    public void driveForwards() {}
    public void turnLeft() {}
    public void stopRobot() {}

    public enum State {
        DRIVE,
        TURN,
        STOP
    }

    public State state = State.DRIVE;
    public int turns = 0;
    public ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    PinpointLocalizer localizer;

    @Override
    public void init() {
        localizer = new PinpointLocalizer(hardwareMap);
    }

    @Override
    public void loop() {
        switch (state) {
            case DRIVE:
                if (timer.seconds() <= 3) {
                    driveForwards();
                }
                else {
                    state = State.TURN;
                    turns += 1;
                }
                break;
            case TURN:
                double targetAngle = turns * 90;
                double currentAngle = localizer.getHeading();
                if (currentAngle < targetAngle) {
                    turnLeft();
                }
                else if (turns < 4) {
                    state = State.DRIVE;
                    timer.reset();
                }
                else {
                    state = State.STOP;
                }
                break;
            case STOP:
                stopRobot();
                break;
        }
    }
}