package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    private DcMotorEx leftFront;
    private DcMotorEx rightFront;
    private DcMotorEx leftRear;
    private DcMotorEx rightRear;

    public Drivetrain(@NonNull HardwareMap hardwareMap) {
        basicMotorSetup(hardwareMap);
    }

    public Drivetrain(@NonNull HardwareMap hardwareMap, @NonNull DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        basicMotorSetup(hardwareMap);

        leftFront.setZeroPowerBehavior(zeroPowerBehavior);
        leftRear.setZeroPowerBehavior(zeroPowerBehavior);
        rightFront.setZeroPowerBehavior(zeroPowerBehavior);
        rightRear.setZeroPowerBehavior(zeroPowerBehavior);
    }

    private void basicMotorSetup(@NonNull HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");

        leftFront.setDirection(DcMotorEx.Direction.FORWARD);
        leftRear.setDirection(DcMotorEx.Direction.FORWARD);
        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        rightRear.setDirection(DcMotorEx.Direction.REVERSE);
    }


}
