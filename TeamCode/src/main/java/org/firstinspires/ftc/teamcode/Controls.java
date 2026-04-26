package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * This separates gamepad handling logic from the rest of teleop code, allowing for easier updates and less mistakes.
 * The example control scheme uses a shift system where a combination of left bumper and left trigger inputs allow accessing different "layers" of controls. This increases the number of possible controls on a single gamepad, making testing and driver practice easier.
 */
public class Controls {
    Gamepad gp1;

    public Gamepad current = new Gamepad();
    public Gamepad last = new Gamepad();

    public double ly, lx, rx, ry, rt, lt;
    public boolean a, b, x, y, rb, lb, dr, du, dl, dd;

    /* General */
    public boolean shift0, shift1, shift2, shift3;
    public double slow, adjust;

    /* Drivetrain */
    public double driveX, driveY, driveR;

    /* Other */
    public boolean autoaim, reset, concurrent;

    /* Outtake */
    public boolean outtake, activateShooter, reverse, transferOverride, velocityIncrease, velocityDecrease, spinUp;

    /* Intake */
    public boolean intake;


    /* Endgame */
    public boolean park, drivePark;

    /* Emergency */
    public boolean enterEmergency, exitEmergency, emergency;
    public boolean turretLeft, turretRight;
    public boolean resetPose;

    public Controls(Gamepad gamepad1) {
        gp1 = gamepad1;
        update(); // populate values
    }

    public void update() {
        copyState();

        /* General */
        shift0 = !lb && !(lt > 0.2); // none
        shift1 = lb && !(lt > 0.2); // left bumper
        shift2 = !lb && (lt > 0.2); // left trigger
        shift3 = lb && (lt > 0.2); // both

        velocityIncrease = du && !last.dpad_up;
        velocityDecrease = dd && !last.dpad_down;

        slow = rt;
        adjust = -ry;

        /* Drivetrain */
        driveX = lx;
        driveY = -ly;

        /* Emergency */
        emergency = shift2 && b && !last.b;
        resetPose = du && !last.dpad_up;
    }

    void copyState() {
        last.copy(current);
        current.copy(gp1);

        ly = current.left_stick_y;
        lx = current.left_stick_x;
        rx = current.right_stick_x;
        ry = current.right_stick_y;
        rt = current.right_trigger;
        lt = current.left_trigger;

        a = current.a;
        b = current.b;
        x = current.x;
        y = current.y;
        rb = current.right_bumper;
        lb = current.left_bumper;
        dr = current.dpad_right;
        du = current.dpad_up;
        dl = current.dpad_left;
        dd = current.dpad_down;
    }
}
