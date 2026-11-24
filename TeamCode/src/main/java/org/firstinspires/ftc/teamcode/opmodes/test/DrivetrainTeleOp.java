package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;
import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;

import java.util.List;

public class DrivetrainTeleOp extends OpMode {
    private List<LynxModule> allHubs;
    private Robot robot;
    private RobotTelemetry robotTelemetry;

    @Override
    public void init() {
        setBulkCache();
        robot = new Robot(hardwareMap, RobotStatus.INIT);

        this.robotTelemetry = new RobotTelemetry(telemetry, robot.status);
    }

    @Override
    public void loop() {
        clearBulkCache();
        robot.status.set(RobotStatus.INITIALIZED);

        double axial    = -gamepad1.left_stick_y;
        double lateral  = gamepad1.left_stick_x;
        double yaw      = gamepad1.right_stick_x;

        robot.drivetrain.drive(axial, lateral, yaw);

        robotTelemetry.update();
    }
    private void setBulkCache() {
        allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    private void clearBulkCache() {
        for (LynxModule hub : allHubs) {
            hub.clearBulkCache();
        }
    }
}
