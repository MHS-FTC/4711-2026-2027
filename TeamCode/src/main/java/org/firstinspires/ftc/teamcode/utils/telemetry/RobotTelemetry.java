package org.firstinspires.ftc.teamcode.utils.telemetry;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotTelemetry {
    private final Telemetry telemetry;
    private final ElapsedTime updateTimer = new ElapsedTime();
    private final double updateIntervalMs;
    private boolean debug;
    private boolean readyToUpdate = true;

    public RobotTelemetry(@NonNull Telemetry telemetry) {
        this.telemetry = telemetry;

        setDebug(false);
    }

    public RobotTelemetry(boolean debug, @NonNull Telemetry telemetry) {
        this.telemetry = telemetry;

        setDebug(debug);

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

    public void toggleDebug() {
        debug = !debug;
    }

    public void setDebug(boolean value) {
        debug = value;
    }

}
