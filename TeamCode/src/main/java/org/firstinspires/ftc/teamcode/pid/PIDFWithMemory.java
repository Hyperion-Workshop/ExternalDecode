package org.firstinspires.ftc.teamcode.pid;

public class PIDFWithMemory extends PIDF {
  public static final PIDFWithMemory ZERO = new PIDFWithMemory(0, 0, 0);

  protected double goal;

  public PIDFWithMemory(double P, double I, double D) {
    super(P, I, D);
  }

  public PIDFWithMemory(double P, double I, double D, double F) {
    super(P, I, D, F);
  }

  public PIDFWithMemory(double P, double I, double D, double F, double maxI) {
    super(P, I, D, F, maxI);
  }

  public double getGoal() {
    return goal;
  }

  public void setGoal(double goal) {
    setGoal(goal, true);
  }

  public void setGoal(double goal, boolean shouldReset) {
    if (shouldReset) reset();
    this.goal = goal;
  }

  public PIDFWithMemory update() {
    return (PIDFWithMemory) super.update();
  }

  public PIDFWithMemory update(double msElapsed) {
    return (PIDFWithMemory) super.update(msElapsed);
  }

  @Override
  public double calc(double current) {
    return super.calc(goal - current);
  }
}
