package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.telemetry.TelemetryReporter;

public class Drivetrain implements TelemetryReporter {
    private DcMotorEx leftFrontDrive;
    private DcMotorEx rightFrontDrive;
    private DcMotorEx leftRearDrive;
    private DcMotorEx rightRearDrive;
    private boolean slowMode = false;
    private double slowFactor = 0.5;

    public Drivetrain(@NonNull HardwareMap hardwareMap) {
        this(hardwareMap, DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public Drivetrain(@NonNull HardwareMap hardwareMap, @NonNull DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        basicMotorSetup(hardwareMap);

        leftFrontDrive.setZeroPowerBehavior(zeroPowerBehavior);
        leftRearDrive.setZeroPowerBehavior(zeroPowerBehavior);
        rightFrontDrive.setZeroPowerBehavior(zeroPowerBehavior);
        rightRearDrive.setZeroPowerBehavior(zeroPowerBehavior);
    }

    private void basicMotorSetup(@NonNull HardwareMap hardwareMap) {
        leftFrontDrive = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRearDrive = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightFrontDrive = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightRearDrive = hardwareMap.get(DcMotorEx.class, "rightRear");

        leftFrontDrive.setDirection(DcMotorEx.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotorEx.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotorEx.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotorEx.Direction.REVERSE);
    }
     public void drive(double axial, double lateral, double yaw) {
        double max;

        double leftFrontPower   = axial + lateral + yaw;
        double leftRearPower    = axial - lateral + yaw;
        double rightFrontPower  = axial - lateral - yaw;
        double rightRearPower   = axial + lateral - yaw;

        max = Math.max(Math.abs(leftFrontPower), Math.abs(leftRearPower));
        max = Math.max(max, Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(rightRearPower));

        max /= (slowMode) ? slowFactor : 1;

        if (max > 1.0) {
            leftFrontPower  /= max;
            leftRearPower   /= max;
            rightFrontPower /= max;
            rightRearPower  /= max;
        }

        leftFrontDrive.setPower(leftFrontPower);
        leftRearDrive.setPower(leftRearPower);
        rightFrontDrive.setPower(rightFrontPower);
        rightRearDrive.setPower(rightRearPower);
     }

     public void setSlowMode(boolean value) { slowMode = value; }
     public void toggleSlowMode() { slowMode = !slowMode; }

     public void toggleSlowMode(boolean wasButtonPressed) {
        if (wasButtonPressed) { toggleSlowMode(); }
     }

     public void setSlowFactor(double value) { slowFactor = value;}

    @Override
    public void reportTelemetry(RobotTelemetry telemetry) {
        telemetry.addDebugData("Drivetrain | leftFrontDrive", "Power", leftFrontDrive.getPower());
        telemetry.addDebugData("Drivetrain | leftRearDrive", "Power", leftRearDrive.getPower());
        telemetry.addDebugData("Drivetrain | rightFrontDrive", "Power", rightFrontDrive.getPower());
        telemetry.addDebugData("Drivetrain | rightRearDrive", "Power", rightRearDrive.getPower());
    }
}