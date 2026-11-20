package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.status.Status;
import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;

@TeleOp(name="TeleOp OpMode", group="Iterative OpMode")
public class MainTeleOp extends OpMode {
    private Status status;
    private RobotTelemetry robotTelemetry;

    @Override
    public void init() {
        this.status = new Status(RobotStatus.INIT);
        this.robotTelemetry = new RobotTelemetry(telemetry, status);

        status.set(RobotStatus.INITIALIZED);
    }

    @Override
    public void loop() {
        robotTelemetry.update();
    }
}
