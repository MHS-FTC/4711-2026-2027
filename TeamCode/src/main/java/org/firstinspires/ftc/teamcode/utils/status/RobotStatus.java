package org.firstinspires.ftc.teamcode.utils.status;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Represents the possible states of the robot.
 * <p>
 * Used across subsystems and {@link com.qualcomm.robotcore.eventloop.opmode.OpMode OpModes} to coordinate actions based on the current
 * phase of a match or initialization routine.
 */
public enum RobotStatus {
    /** Default status before {@link OpMode#init() init()} has been called. */
    NONEXISTENT,

    /** Status while {@link OpMode#init() init()} is actively executing. */
    INIT,

    /** Status after {@link OpMode#loop() loop()} has finished running. */
    INITIALIZED,

    /** Default status while {@link OpMode#loop() loop()} is running. */
    RUNNING,

    /** Status while the robot is executing a launch sequence. */
    LAUNCHING
}
