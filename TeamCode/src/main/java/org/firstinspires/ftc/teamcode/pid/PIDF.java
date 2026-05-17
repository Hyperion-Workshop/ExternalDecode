package org.firstinspires.ftc.teamcode.pid;

import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * PID controller class.
 *
 * @see <a href="https://gm0.org/en/latest/docs/software/concepts/control-loops.html">GM0</a>
 */
public class PIDF {
  public static final PIDF ZERO = new PIDF(0, 0, 0);

  public boolean isDrivetrainPID;
  public double P;
  public double I;
  public double D;
  public double F;

  public double maxI = Double.MAX_VALUE;

  private double deltaTime = 0;
  private ElapsedTime timer;

  private double iSum = 0;
  private double lastError = 0;

  public PIDF(double P, double I, double D) {
    this.P = P;
    this.I = I;
    this.D = D;

    timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
  }

  public PIDF(double P, double I, double D, double F) {
    this(P, I, D);

    this.F = F;
  }

  public PIDF(double P, double I, double D, double F, boolean isDrivetrainPID) {
    this(P, I, D);

    this.F = F;
    this.isDrivetrainPID = isDrivetrainPID;
  }

  public PIDF(double P, double I, double D, double F, double maxI) {
    this(P, I, D, F);

    this.maxI = maxI;
  }

  public void reset() {
    timer.reset();
    deltaTime = 0;
    iSum = 0;
    lastError = 0;
  }

  public PIDF update(double msElapsed) {
    deltaTime = msElapsed / 1000;
    timer.reset();

    return this;
  }

  public PIDF update() {
    return update(timer.milliseconds());
  }

  public double calcWithFMultiplier(double error, double fMultiplier) {
    return calc(error, F * fMultiplier);
  }

  public double calc(double error) {
    return calc(error, F);
  }

  public double calc(double error, double f) {
    double p = P * error;
    iSum += I * error * deltaTime;

    if (iSum > maxI) iSum = maxI;
    else if (iSum < -maxI) iSum = -maxI;

    double d = deltaTime != 0 ? (D * (error - lastError) / deltaTime) : 0;
    lastError = error;

    return p + iSum + d + f * (isDrivetrainPID ? Math.signum(error) : 1);
  }
}
