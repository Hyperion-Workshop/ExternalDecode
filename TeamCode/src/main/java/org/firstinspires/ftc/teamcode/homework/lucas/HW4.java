package org.firstinspires.ftc.teamcode.homework.lucas;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name = "pickup, dropoff")
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
        DRIVE_TO_THING,
        OPEN_CLAW1,
        CLOSE_CLAW,
        DRIVE_TO_BASKET,
        OPEN_CLAW2,
        STOP
    }
    public State state = State.DRIVE_TO_THING;
    public ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


    @Override
    public void runOpMode() throws InterruptedException {
        /* pretend initialization code is here */
        waitForStart();

        while (opModeIsActive()) {
            /* your code here */
            switch (state) {
                case DRIVE_TO_THING:
                    if (!arrivedAtThing) {
                        driveToThing();
                    }
                    else {
                        state = State.OPEN_CLAW1;
                        timer.reset();
                    }
                    break;
                case OPEN_CLAW1:
                    if (timer.seconds() <= 0.2) {
                        openClaw();
                    }
                    else {
                        state = State.CLOSE_CLAW;
                        timer.reset();
                    }
                    break;
                case CLOSE_CLAW:
                    if (timer.seconds() <= 0.4) {
                        closeClaw();
                    }
                    else {
                        state = State.DRIVE_TO_BASKET;
                    }
                    break;
                case DRIVE_TO_BASKET:
                    if (!arrivedAtBasket) {
                        driveToBasket();
                    }
                    else {
                        state = State.OPEN_CLAW2;
                        timer.reset();
                    }
                    break;
                case OPEN_CLAW2:
                    if (timer.seconds() <= 0.2) {
                        openClaw();
                    }
                    else {
                        state = State.STOP;
                    }
                    break;
                case STOP:
                    stop();
                    break;
            }
        }
    }
}