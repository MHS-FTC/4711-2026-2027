package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;
import org.firstinspires.ftc.teamcode.utils.status.Status;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class Robot {
    public Status status;
    public Drivetrain drivetrain;
    public Intake intake;

    public Robot(@NonNull HardwareMap hardwareMap) {
        status      = new Status();
        drivetrain  = new Drivetrain(hardwareMap);
        intake      = new Intake(hardwareMap);
    }

    public Robot(@NonNull HardwareMap hardwareMap, @NonNull RobotStatus initialStatus) {
        status      = new Status(initialStatus);
        drivetrain  = new Drivetrain(hardwareMap);
        intake      = new Intake(hardwareMap);
    }
}
