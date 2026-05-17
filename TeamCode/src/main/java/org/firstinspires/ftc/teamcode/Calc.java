package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Calc {
    /**
     * Computes the largest absolute value of four values.
     * Used in mecanum drivetrain calculations.
     */
    public static double maxMagnitudeOfFour(double a, double b, double c, double d) {
        return Math.max(Math.max(Math.abs(a), Math.abs(b)),
                Math.max(Math.abs(c), Math.abs(d)));
    }

    public static double distanceSquared(double x1, double y1, double x2, double y2) {
        return Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
    }

    /**
     * Calculate the distance between two points on a plane. This is faster but less accurate than Math.hypot()
     */
    public static double distanceBetween(double x1, double y1, double x2, double y2) {
        return Math.sqrt(distanceSquared(x1, y1, x2, y2));
    }

    /**
     * Calculate the integer log base 2 of a number.
     * binlog(0) is 0.
     * https://stackoverflow.com/a/3305710
     */
    public static int binlog(int bits) {
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 ) + 1; // Fix hash collision with constraint solver
    }

    //angle to degree -180 < theta <= 180
    public static double angleWrap(double angle) {
      angle = (angle % 360 + 360) % 360;
      if (angle > 180) {
        angle -= 360;
      }
      return angle;
    }

    public static double angleWrapNinety(double angle) {
        angle %= 180;
        if (angle > 90) angle -= 180;
        if (angle <= -90) angle += 180;
        return angle;
    }

    public static double clamp(double val, double min, double max) {
      return Math.min(max, Math.max(min, val));
    }


    public static int clamp(int val, int min, int max) {
        return Math.min(max, Math.max(min, val));
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }
}
