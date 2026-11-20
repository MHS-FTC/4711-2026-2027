package org.firstinspires.ftc.teamcode.utils.telemetry;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utils.status.Status;

public class RobotTelemetry {
    private final Telemetry telemetry;
    public final Status status;

    public RobotTelemetry(Telemetry telemetry, Status status) {
        this.telemetry = telemetry;
        this.status = status;
    }

    public void update() {
        telemetry.addData("Status", status.current());

    }

    public void update(boolean debug) {
        if (!debug) {update();}
        telemetry.addLine("==== Status ====")
            .addData("Current", status.current())
            .addData("Previous", status.current());
    }
}
