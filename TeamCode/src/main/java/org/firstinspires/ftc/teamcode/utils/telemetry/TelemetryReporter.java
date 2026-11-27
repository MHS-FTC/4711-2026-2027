package org.firstinspires.ftc.teamcode.utils.telemetry;

/**
 * Standardizes telemetry reporting method across subassemblies.
 */
public interface TelemetryReporter {

    /**
     * Report subassembly-specific telemetry data using the {@link RobotTelemetry} wrapper.
     *
     * <p>Example usage:
     * <pre>{@code
     * @Override
     * public void reportTelemetry(RobotTelemetry telemetry) {
     *     telemetry.addData("Drivetrain | SlowMode", slowMode);
     *
     *     telemetry.addDebugData("Drivetrain | SlowFactor", slowFactor);
     *     telemetry.addDebugData("Drivetrain | leftFrontDrive", "Power", leftFrontDrive.getPower());
     * }
     * }</pre>
     *
     * @param telemetry Instance of {@link RobotTelemetry}.
     */
    void reportTelemetry(RobotTelemetry telemetry);
}
