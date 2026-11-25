package org.firstinspires.ftc.teamcode.utils.telemetry;

import androidx.annotation.NonNull;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.utils.status.Status;

public class RobotTelemetry {
    private boolean DEBUG;
    private final Telemetry telemetry;

    public RobotTelemetry(@NonNull Telemetry telemetry) {
        setDebug(false);

        this.telemetry = telemetry;
    }

    public RobotTelemetry(boolean debug, @NonNull Telemetry telemetry) {
        setDebug(debug);

        this.telemetry = telemetry;

    }

    public void update() {

    }

    public void toggleDebug() {
        DEBUG = !DEBUG;
    }

    public void setDebug(boolean value) {
        DEBUG = value;
    }

}
