package org.firstinspires.ftc.teamcode.homework.Fred;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "pickup, dropoff")
public class HW4 extends LinearOpMode {
    public void openClaw() {}
    public void closeClaw() {}
    public boolean arrivedAtThing = false;
    public void driveToThing() {}
    public boolean arrivedAtBasket = false;
    public void driveToBasket() {}
    public void stopRobot() {}

    public enum State{
        DRIVE_TO_THING,
        CLOSE,
        DRIVE_TO_BASKET,
        OPEN,
        STOP,
    }

    public State robot = State.DRIVE_TO_THING;

    public ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    double currentTime;

    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeInInit()){
            currentTime=timer.seconds();
        }

        waitForStart();

        while (opModeIsActive()) {
            switch(robot){
                case DRIVE_TO_THING:
                    if(!arrivedAtThing){
                        driveToThing();
                    }else{
                        timer.reset();
                        robot = State.OPEN;
                    }
                    break;

                case OPEN:
                    if((arrivedAtThing || arrivedAtBasket) && timer.time() < 200){
                        openClaw();
                    }else{
                        robot = State.CLOSE;
                    }
                    break;

                case CLOSE:
                    if(timer.time() <= 400){
                        openClaw();
                    }else{
                        robot = State.DRIVE_TO_BASKET;
                    }
                    break;

                case DRIVE_TO_BASKET:
                    if(arrivedAtThing && !arrivedAtBasket){
                        driveToBasket();
                    }else{
                        robot = State.STOP;
                        timer.reset();
                    }
                    break;



                case STOP:
                    stopRobot();
                    break;
            }
        }
    }
}