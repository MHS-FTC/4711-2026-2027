package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.utils.telemetry.RobotTelemetry;
import org.firstinspires.ftc.teamcode.utils.status.Status;
import org.firstinspires.ftc.teamcode.utils.status.RobotStatus;

@TeleOp(name="TeleOp OpMode", group="Iterative OpMode")
public class MainTeleOp extends OpMode {
    private Robot robot;
    private RobotTelemetry robotTelemetry;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, RobotStatus.INIT);

        this.robotTelemetry = new RobotTelemetry(telemetry, robot.status);
    }

    @Override
    public void loop() {
        robot.status.set(RobotStatus.INITIALIZED);

        robotTelemetry.update();
    }
}
