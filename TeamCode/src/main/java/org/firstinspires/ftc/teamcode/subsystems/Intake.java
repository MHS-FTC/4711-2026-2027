package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotorEx intakeMotor;

    public Intake(@NonNull HardwareMap hardwareMap) {
        basicMotorSetup(hardwareMap);
        basicMotorDirection(DcMotorSimple.Direction.FORWARD);
    }

    public Intake(@NonNull HardwareMap hardwareMap, DcMotorSimple.Direction direction) {
        basicMotorSetup(hardwareMap);
        basicMotorDirection(direction);
    }

    private void basicMotorSetup(@NonNull HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
    }

    private void basicMotorDirection(@NonNull DcMotorSimple.Direction direction) {
        intakeMotor.setDirection(direction);
    }
}
