package org.firstinspires.ftc.teamcode.homework.shane;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.hyperionModules.PinpointLocalizer;

import java.nio.ByteOrder;

/* Program dt to go in 48 x 48 square
class called CW21 LinearOpMode

4 motors; Dt.motor.lf, Dt.motor.rf, Dt.motor.lb, Dt.motor.rb

left motors REVERSE, right motors FORWARD
robot drive forward for X seconds, turn right, drive forward, etc.
Time-based controls
*/
public class HW3a extends LinearOpMode {
    DcMotorImplEx motorlf;
    DcMotorImplEx motorlb;
    DcMotorImplEx motorrf;
    DcMotorImplEx motorrb;
    ElapsedTime noble;
    int forwardTime = 4; //change for time while going forward
    int turnTime = 4; //change for time while turning

    PinpointLocalizer localizer;

    public void setPowers(double lf, double lb, double rf, double rb) {
        motorlf.setPower(lf);
        motorlb.setPower(lb);
        motorrf.setPower(rf);
        motorrb.setPower(rb);

    }

    //localizer.pinpoint.getHeading(AngleUnit.DEGREES)

    /*
    public void setPosX(double posX, DistanceUnit distanceUnit){
        writeByteArray(GoBildaPinpointDriver.Register.X_POSITION,(floatToByteArray((float) distanceUnit.toMm(posX), ByteOrder.LITTLE_ENDIAN)));
    }

    public void setPosY(double posY, DistanceUnit distanceUnit){
        writeByteArray(GoBildaPinpointDriver.Register.Y_POSITION,(floatToByteArray((float) distanceUnit.toMm(posY), ByteOrder.LITTLE_ENDIAN)));
    }

    public double getPosX(DistanceUnit distanceUnit){
        return distanceUnit.fromMm(xPosition);
    }

    public double getPosY(DistanceUnit distanceUnit){
        return distanceUnit.fromMm(yPosition);
    }



    public void setHeading(double heading, AngleUnit angleUnit){
        writeByteArray(GoBildaPinpointDriver.Register.H_ORIENTATION,(floatToByteArray((float) angleUnit.toRadians(heading), ByteOrder.LITTLE_ENDIAN)));
    }

    public double getHeading(AngleUnit angleUnit){
        return angleUnit.fromRadians((hOrientation + Math.PI) % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI) - Math.PI;
    }


     */

    @Override
    public void runOpMode() throws InterruptedException {
        //declare variables

        while (opModeInInit()) {
            //init
            motorlf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lf");
            motorlb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.lb");
            motorrf = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rf");
            motorrb = hardwareMap.get(DcMotorImplEx.class, "Dt.motor.rb");

            motorlf.setDirection(DcMotorSimple.Direction.REVERSE);
            motorlb.setDirection(DcMotorSimple.Direction.REVERSE);
            motorrf.setDirection(DcMotorSimple.Direction.FORWARD);
            motorrb.setDirection(DcMotorSimple.Direction.FORWARD);

            localizer = new PinpointLocalizer(hardwareMap);


        }
        waitForStart();

        while (opModeIsActive()) {
            // code
            //go forward
            //when time is greater than forward time, start turn
            //when turn is over, reset timer
            if (noble.seconds() <= forwardTime) {
                setPowers(1, 1, 1, 1);
            } else {
                while (localizer.pinpoint.getHeading(AngleUnit.DEGREES) % 90 >= 85) {
                    setPowers(-1, -1, 1, 1);
                }
                while (localizer.pinpoint.getHeading(AngleUnit.DEGREES) % 90 < 85) {
                    setPowers(-1, -1, 1, 1);
                }
                noble.reset();
            }
            // if (localizer.pinpoint.getHeading(AngleUnit.DEGREES) % 90 == 0);



        }
    }
}
