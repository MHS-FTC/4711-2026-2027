package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.status.Status;
import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;

import java.util.List;

@TeleOp(name="TeleOp OpMode", group="Iterative OpMode")
public class MainTeleOp extends OpMode {
    private List<LynxModule> allHubs;
    private Robot robot;

    @Override
    public void init() {
        setBulkCache();
        robot = new Robot(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        clearBulkCache();
        robot.status.set(RobotStatus.INITIALIZED);

        robot.drivetrain.drive(gamepad1);

        robot.reportTelemetry();
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
