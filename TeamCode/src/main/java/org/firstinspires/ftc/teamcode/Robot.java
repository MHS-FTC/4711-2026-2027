package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class Robot {
    public Drivetrain drivetrain;
    public Intake intake;

    public Robot(@NonNull HardwareMap hardwareMap) {
        drivetrain = new Drivetrain(hardwareMap);
        intake = new Intake(hardwareMap);
    }
}
