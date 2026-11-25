package org.firstinspires.ftc.teamcode.utils.status;

import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.telemetry.TelemetryReporter;

public class Status implements TelemetryReporter {
    private RobotStatus current = RobotStatus.NONEXISTENT;
    private RobotStatus previous = RobotStatus.NONEXISTENT;

    public Status() {}

    public Status(RobotStatus status) {
        this.set(status);
    }

    public RobotStatus current() {
        return current;
    }

    public RobotStatus previous() {
        return previous;
    }

    public void set(RobotStatus status) {
        if (status != this.current) {
            this.previous   = this.current;
            this.current    = status;
        }
    }

    @Override
    public void reportTelemetry(RobotTelemetry telemetry) {
        telemetry.addData("Status", "Current", current());
        telemetry.addDebugData("Status", "Previous", previous());
    }
}
