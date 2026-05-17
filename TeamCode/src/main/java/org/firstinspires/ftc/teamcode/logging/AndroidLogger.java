package org.firstinspires.ftc.teamcode.logging;

import android.util.Log;

public class AndroidLogger implements ILogger {
  public void i(String tag, String msg) {
    Log.i(tag, msg);
  }

  public void d(String tag, String msg) {
    Log.i(tag, msg);
  }

  public void w(String tag, String msg) {
    Log.i(tag, msg);
  }

  public void e(String tag, String msg) {
    Log.i(tag, msg);
  }
}
