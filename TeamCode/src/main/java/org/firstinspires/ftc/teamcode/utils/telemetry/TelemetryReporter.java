package org.firstinspires.ftc.teamcode.utils.telemetry;

/**
 * Standardizes telemetry reporting method across subassemblies.
 * <pre>{@code
 * public class Subassembly implements TelemetryReporter {
 *     @Override
 *     public void reportTelemetry(RobotTelemetry telemetry) {
 *         // Add telemetry calls here
 *     }
 * }
 * }</pre>
 */
public interface TelemetryReporter {

    /**
     * Reports subassembly-specific telemetry data using the {@link RobotTelemetry} wrapper.
     *
     * <p>Example usage:
     * <pre>{@code
     * @Override
     * public void reportTelemetry(RobotTelemetry telemetry) {
     *     telemetry.addData("Drivetrain | SlowMode", slowMode);
     *     telemetry.addDebugData("Drivetrain | SlowFactor", slowFactor);
     *     telemetry.addDebugData("Drivetrain | leftFrontDrive", "Power", leftFrontDrive.getPower());
     * }
     * }</pre>
     *
     * @param telemetry The {@link RobotTelemetry} instance used to log subassembly data.
     */
    void reportTelemetry(RobotTelemetry telemetry);
}
