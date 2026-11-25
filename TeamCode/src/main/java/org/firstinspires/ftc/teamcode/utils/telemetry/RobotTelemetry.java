package org.firstinspires.ftc.teamcode.utils.telemetry;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

public class RobotTelemetry {
    private final Telemetry telemetry;
    private final ElapsedTime updateTimer = new ElapsedTime();
    private final double updateIntervalMs;
    private boolean debug;
    private boolean readyToUpdate = true;

    public RobotTelemetry(@NonNull Telemetry telemetry) {
        this(telemetry, 100, false);
    }

    public RobotTelemetry(@NonNull Telemetry telemetry, double updateIntervalMs) {
        this(telemetry, updateIntervalMs, false);
    }

    public RobotTelemetry(@NonNull Telemetry telemetry, double updateIntervalMs, boolean debug) {
        this.telemetry  = telemetry;
        this.updateIntervalMs = updateIntervalMs;
        this.debug = debug;
        this.updateTimer.reset();
    }

    public void toggleDebug() {
        debug = !debug;
    }

    public void setDebug(boolean value) {
        debug = value;
    }

    public boolean shouldUpdate() {
        if (updateTimer.milliseconds() >= updateIntervalMs) {
            updateTimer.reset();
            readyToUpdate = true;
        } else {
            readyToUpdate = false;
        }
        return readyToUpdate;
    }

    public void update() {
        if (readyToUpdate) {
            telemetry.update();
        }
    }

    public void addData(String caption, Object value) {
        telemetry.addData(caption, value);
    }

    public void addData(String caption, String format, Object... args) {
        telemetry.addData(caption, format, args);
    }

    public void addDebugData(String caption, Object value) {
        if (!debug) return;
        telemetry.addData("[DEBUG] " + caption, value);
    }

    public void addDebugData(String caption, String format, Object... args) {
        if (!debug) return;
        telemetry.addData("[DEBUG] " + caption, format, args);
    }


}
