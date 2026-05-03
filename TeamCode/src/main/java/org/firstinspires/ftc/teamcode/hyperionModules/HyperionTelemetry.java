package org.firstinspires.ftc.teamcode.hyperionModules;

import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class HyperionTelemetry implements Telemetry {
    FtcDashboard ftcDashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = ftcDashboard.getTelemetry();
    Telemetry telemetry;

    public HyperionTelemetry(Telemetry p_telemetry) {
        this.telemetry = p_telemetry;
    }

    @Override
    public Item addData(String caption, String format, Object... args) {
        dashboardTelemetry.addData(caption, format, args);
        telemetry.addData(caption, format, args);
        return null;
    }

    @Override
    public Item addData(String caption, Object value) {
        dashboardTelemetry.addData(caption, value);
        telemetry.addData(caption, value);
        return null;
    }

    @Override
    public <T> Item addData(String caption, Func<T> valueProducer) {
        dashboardTelemetry.addData(caption, valueProducer);
        telemetry.addData(caption, valueProducer);
        return null;
    }

    @Override
    public <T> Item addData(String caption, String format, Func<T> valueProducer) {
        dashboardTelemetry.addData(caption, format, valueProducer);
        telemetry.addData(caption, format, valueProducer);
        return null;
    }

    @Override
    public boolean removeItem(Item item) {
        dashboardTelemetry.removeItem(item);
        telemetry.removeItem(item);
        return false;
    }

    @Override
    public void clear() {
        dashboardTelemetry.clear();
        telemetry.clear();
    }

    @Override
    public void clearAll() {
        dashboardTelemetry.clearAll();
        telemetry.clearAll();
    }

    @Override
    public Object addAction(Runnable action) {
        dashboardTelemetry.addAction(action);
        telemetry.addAction(action);
        return null;
    }

    @Override
    public boolean removeAction(Object token) {
        dashboardTelemetry.removeAction(token);
        telemetry.removeAction(token);
        return false;
    }

    @Override
    public void speak(String text) {
        dashboardTelemetry.speak(text);
        telemetry.speak(text);
    }

    @Override
    public void speak(String text, String languageCode, String countryCode) {
        dashboardTelemetry.speak(text, languageCode, countryCode);
        telemetry.speak(text, languageCode, countryCode);
    }

    @Override
    public boolean update() {
        dashboardTelemetry.update();
        telemetry.update();
        return false;
    }

    @Override
    public Line addLine() {
        dashboardTelemetry.addLine();
        telemetry.addLine();
        return null;
    }

    @Override
    public Line addLine(String lineCaption) {
        dashboardTelemetry.addLine(lineCaption);
        telemetry.addLine(lineCaption);
        return null;
    }

    @Override
    public boolean removeLine(Line line) {
        dashboardTelemetry.removeLine(line);
        telemetry.removeLine(line);
        return false;
    }

    @Override
    public boolean isAutoClear() {
        dashboardTelemetry.isAutoClear();
        telemetry.isAutoClear();
        return false;
    }

    @Override
    public void setAutoClear(boolean autoClear) {
        dashboardTelemetry.setAutoClear(autoClear);
        telemetry.setAutoClear(autoClear);
    }

    @Override
    public int getMsTransmissionInterval() {
        return 0;
    }

    @Override
    public void setMsTransmissionInterval(int msTransmissionInterval) {
        dashboardTelemetry.setMsTransmissionInterval(msTransmissionInterval);
        telemetry.setMsTransmissionInterval(msTransmissionInterval);
    }

    @Override
    public String getItemSeparator() {
        return "";
    }

    @Override
    public void setItemSeparator(String itemSeparator) {
        dashboardTelemetry.setItemSeparator(itemSeparator);
        telemetry.setItemSeparator(itemSeparator);
    }

    @Override
    public String getCaptionValueSeparator() {
        return "";
    }

    @Override
    public void setCaptionValueSeparator(String captionValueSeparator) {
        dashboardTelemetry.setCaptionValueSeparator(captionValueSeparator);
        telemetry.setCaptionValueSeparator(captionValueSeparator);
    }

    @Override
    public void setDisplayFormat(DisplayFormat displayFormat) {
        dashboardTelemetry.setDisplayFormat(displayFormat);
        telemetry.setDisplayFormat(displayFormat);
    }

    @Override
    public Log log() {
        return null;
    }
}
