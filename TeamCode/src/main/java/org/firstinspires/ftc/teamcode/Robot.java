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
    public Status status;
    public RobotTelemetry telemetry;
    public Drivetrain drivetrain;
    public Intake intake;
    public Robot(@NonNull HardwareMap hardwareMap, @NonNull Telemetry telemetry, @NonNull RobotStatus initialStatus) {
        status      = new Status(initialStatus);
        drivetrain  = new Drivetrain(hardwareMap);
        intake      = new Intake(hardwareMap);

        this.telemetry   = new RobotTelemetry(telemetry);

    }

    public Robot(@NonNull HardwareMap hardwareMap, @NonNull Telemetry telemetry) {
        new Robot(hardwareMap, telemetry, RobotStatus.INIT);
    }
}
