package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;
import org.firstinspires.ftc.teamcode.utils.status.Status;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;

public class Robot {
    private RobotTelemetry robotTelemetry;
    public Status status;
    public Drivetrain drivetrain;
    public Intake intake;
    public Robot(@NonNull HardwareMap hardwareMap, @NonNull Telemetry telemetry, @NonNull RobotStatus initialStatus) {
        robotTelemetry  = new RobotTelemetry(telemetry);
        status          = new Status(initialStatus);
        drivetrain      = new Drivetrain(hardwareMap);
        intake          = new Intake(hardwareMap);

    }

    public Robot(@NonNull HardwareMap hardwareMap, @NonNull Telemetry telemetry) {
        this(hardwareMap, telemetry, RobotStatus.INIT);
    }

    public void reportTelemetry() {
        if (!robotTelemetry.shouldUpdate()) { return; }

        status.reportTelemetry(robotTelemetry);
        drivetrain.reportTelemetry(robotTelemetry);
        intake.reportTelemetry(robotTelemetry);

        robotTelemetry.update();
    }
}
