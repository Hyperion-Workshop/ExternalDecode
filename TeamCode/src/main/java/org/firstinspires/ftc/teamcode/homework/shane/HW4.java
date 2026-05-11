package org.firstinspires.ftc.teamcode.homework.shane;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "pickup, dropoff")
public class HW4 extends LinearOpMode {

    // claw takes 200 milliseconds to open after calling the function. (0.2 seconds)
    public void openClaw() { /* pretend code is here. */ }

    // claw takes 400 milliseconds to close (0.4 seconds)
    public void closeClaw() { /* pretend code is here. */ }

    // when driving, arrivedAtThing = false,
    // after arriving, arrivedAtThing = true
    public boolean arrivedAtThing = false;
    public void driveToThing() { /* pretend code is here. */ }

    // when driving, arrivedAtBasket = false,
    // after arriving, arrivedAtBasket = true
    public boolean arrivedAtBasket = false;
    public void driveToBasket() { /* pretend code is here. */ }

    // TODO: for you.
    // 1. make an enum that contains your states
    // 2. make variables that help you keep track of what's going on (hint: timers, current state, ...)
    // 3. write a switch statement that controls the robot

    public enum State {
        DRIVETHING,
        CLAWOPEN,
        CLAWCLOSED,
        DRIVEBASKET,
    }

    public State state = State.DRIVETHING;
    public ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    double currentTime;

    @Override
    public void runOpMode() throws InterruptedException {
        /* pretend initialization code is here */


        while (opModeInInit()) {
            currentTime = timer.seconds();
            openClaw();
        }
        
        waitForStart();
        while (opModeIsActive()) {
            /* your code here */
            switch(state) {
                case DRIVETHING:
                    if (!arrivedAtThing) {
                        driveToThing();
                    } else {
                        state = State.CLAWCLOSED;
                    }
                    break;
                case CLAWCLOSED:
                    closeClaw();
                    currentTime = timer.seconds();
                    if (timer.seconds() > currentTime + 0.4) {
                        state = State.DRIVEBASKET;
                    }
                    break;
                case DRIVEBASKET:
                    if (!arrivedAtBasket) {
                        driveToBasket();
                    } else {
                        state = State.CLAWOPEN;
                    }
                    break;
                case CLAWOPEN:
                    openClaw();
                    currentTime = timer.seconds();
                    if (timer.seconds() > currentTime + 0.2) {
                        state = State.DRIVETHING;
                    }
            }
        }
    }
}