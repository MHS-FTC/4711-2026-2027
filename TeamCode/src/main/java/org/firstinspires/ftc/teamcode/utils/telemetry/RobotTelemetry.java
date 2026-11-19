package org.firstinspires.ftc.teamcode.utils.telemetry;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utils.status.Status;

public class RobotTelemetry {
    private final Telemetry telemetry;
    public final Status status;

    public RobotTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
        this.status = new Status();
    }


}
