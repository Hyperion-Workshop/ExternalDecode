package org.firstinspires.ftc.teamcode.logging;

public class StdoutLogger implements ILogger {
  public void i(String tag, String msg) {
    System.out.println("[" + tag + "] " + msg);
  }

  public void d(String tag, String msg) {
    i(tag, msg);
  }

  public void w(String tag, String msg) {
    i(tag, msg);
  }

  public void e(String tag, String msg) {
    i(tag, msg);
  }
}
