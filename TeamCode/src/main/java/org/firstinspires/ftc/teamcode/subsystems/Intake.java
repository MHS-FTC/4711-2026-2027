package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.telemetry.TelemetryReporter;

public class Intake implements TelemetryReporter {
    private DcMotorEx intakeMotor;

    public Intake(@NonNull HardwareMap hardwareMap) {
        this(hardwareMap, DcMotorSimple.Direction.FORWARD);
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

    @Override
    public void reportTelemetry(RobotTelemetry telemetry) {
        telemetry.addDebugData("Intake | Motor", "Direction", intakeMotor.getDirection());
    }
}
