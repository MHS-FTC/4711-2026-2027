package org.firstinspires.ftc.teamcode.utils.status;

/**
 * Represents the possible states of the robot.
 * <p>
 * Used across subsystems and OpModes to coordinate actions based on the current
 * phase of a match or initialization routine.
 */
public enum RobotStatus {
    /** Default status before the OpMode {@code init()} method has been called. */
    NONEXISTENT,

    /** Status while the OpMode {@code init()} method is actively executing. */
    INIT,

    /** Status after the OpMode {@code init()} method has finished running. */
    INITIALIZED,

    /** Default status while the OpMode {@code loop()} method is running. */
    RUNNING,

    /** Status while the robot is executing a launch sequence. */
    LAUNCHING
}
