package org.firstinspires.ftc.teamcode.utils.telemetry;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * A wrapper for the FTC {@link Telemetry} interface that adds rate-limiting,
 * subassembly prefixing, and toggleable debug logging.
 *
 * <p>To enforce the update interval, check {@link #shouldUpdate()} before adding
 * data, and call {@link #update()} at the end of the loop:
 * <pre>{@code
 * if (robotTelemetry.shouldUpdate()) {
 *     robotTelemetry.addData("Drive", "Velocity", velocity);
 *     robotTelemetry.update();
 * }
 * }</pre>
 * 
 * <p>Usage in a Robot class could include a global update with subassemblies adding
 * their own specific data themselves using {@link TelemetryReporter#reportTelemetry(RobotTelemetry) reportTelemetry}:
 * <pre>{@code
 * public void reportTelemetry() {
 *     // early return if shouldUpdate() returns false
 *     if (!robotTelemetry.shouldUpdate()) { return; }
 *
 *     // log telemetry data
 *     oneSubassembly.reportTelemetry(robotTelemetry);
 *     anotherSubassembly.reportTelemetry(robotTelemetry);
 *
 *     // global telemetry update
 *     robotTelemetry.update();
 * }
 * }</pre>
 */
public class RobotTelemetry {
    /**
     * Instance of {@link Telemetry}. Only accessible through class methods to ensure constancy.
     */
    private final Telemetry telemetry;

    /**
     * Standard timer used to determine whether the telemetry should be updated.
     *
     * @see #shouldUpdate()
     */
    private final ElapsedTime updateTimer = new ElapsedTime();

    /**
     * Minimum time that must pass in milliseconds before the telemetry can update.
     *
     * @see #shouldUpdate()
     */
    private final double updateIntervalMs;

    /**
     * Controls whether designed debug data is shown in logged in the telemetry.
     *
     * @see #isDebug()
     * @see #setDebug(boolean)
     * @see #toggleDebug()
     * @see #addDebugData(String, Object)
     * @see #addDebugData(String, String, Object)
     * @see #addDebugData(String, String, Object...)
     * @see #addDebugData(String, String, String, Object...)
     */
    private boolean debug;

    /**
     * Represents if the {@link #updateTimer} is greater than the {@link #updateIntervalMs}.
     * Controls whether {@link #update()} runs {@link Telemetry#update()}.
     *
     * @see #shouldUpdate()
     * @see #update()
     */
    private boolean readyToUpdate = false;

    /**
     * Creates a new RobotTelemetry instance with a default 100ms update interval
     * and debug mode disabled. Initially set to false to avoid abrupt updates.
     * @param telemetry The underlying FTC {@link Telemetry} object from the OpMode.
     * @see RobotTelemetry(Telemetry, double)
     * @see RobotTelemetry(Telemetry, double, boolean)
     */
    public RobotTelemetry(@NonNull Telemetry telemetry) {
        this(telemetry, 100);
    }

    /**
     * Creates a new RobotTelemetry instance with a custom update interval
     * and debug mode disabled.
     *
     * @param telemetry         The underlying FTC {@link Telemetry} object from the OpMode.
     * @param updateIntervalMs  Minimum time in milliseconds between telemetry updates.
     * @see RobotTelemetry(Telemetry)
     * @see RobotTelemetry(Telemetry, double, boolean)
     */
    public RobotTelemetry(@NonNull Telemetry telemetry, double updateIntervalMs) {
        this(telemetry, updateIntervalMs, false);
    }

    /**
     * Creates a new RobotTelemetry instance with custom update interval and debug mode.
     *
     * @param telemetry         The underlying FTC {@link Telemetry} object from the OpMode.
     * @param updateIntervalMs  Minimum time in milliseconds between telemetry updates.
     * @param debug             Whether debug data should be displayed initially.
     * @see RobotTelemetry(Telemetry)
     * @see RobotTelemetry(Telemetry, double)
     */
    public RobotTelemetry(@NonNull Telemetry telemetry, double updateIntervalMs, boolean debug) {
        this.telemetry  = telemetry;
        this.updateIntervalMs = updateIntervalMs;
        this.debug = debug;
    }

    /**
     * Inverts current debug logging state.
     */
    public void toggleDebug() {
        debug = !debug;
    }

    /**
     * Enables or disables debug telemetry logging output.
     *
     * @param value {@code true} to show debug data; {@code false} to suppress it.
     */
    public void setDebug(boolean value) {
        debug = value;
    }

    /**
     * Checks whether debug logging is currently enabled.
     *
     * @return {@code true} if debug logging is active; {@code false} otherwise.
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Checks if enough time has elapsed since last telemetry update.
     * If the minimum threshold has been surpassed, the timer is reset
     * and allows {@link #update()} to transmit the data.
     *
     * @return {@code true} if telemetry should be updated during this loop; {@code false} otherwise.
     */
    public boolean shouldUpdate() {
        if (updateTimer.milliseconds() >= updateIntervalMs) {
            updateTimer.reset();
            readyToUpdate = true;
        } else {
            readyToUpdate = false;
        }
        return readyToUpdate;
    }

    /**
     * Transmits logged telemetry data to the Driver Station if {@link #readyToUpdate}
     * returned {@code true} during current cycle.
     */
    public void update() {
        if (readyToUpdate) {
            telemetry.update();
            readyToUpdate = false;
        }
    }

    /**
     * Adds a standard key-value item to telemetry.
     *
     * @param caption   The caption to use.
     * @param value     The value to display.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addData(String, String, Object)
     * @see #addData(String, String, Object...)
     * @see #addData(String, String, String, Object...)
     */
    public RobotTelemetry addData(String caption, Object value) {
        telemetry.addData(caption, value);
        return this;
    }

    /**
     * Adds a key-value item prefixed with a subassembly name (e.g., {@code "Subassembly | Caption"}).
     *
     * @param subassembly   The robot subsystem name.
     * @param caption       The caption to use.
     * @param value         The value to display.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addData(String, Object)
     * @see #addData(String, String, Object...)
     * @see #addData(String, String, String, Object...)
     */
    public RobotTelemetry addData(String subassembly, String caption, Object value) {
        telemetry.addData(subassembly + " | " + caption, value);
        return this;
    }

    /**
     * Adds a formatted string item to telemetry.
     *
     * @param caption   The caption to use.
     * @param format    The string by which the arguments are to be formatted.
     * @param args      The arguments to format.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addData(String, Object)
     * @see #addData(String, String, Object)
     * @see #addData(String, String, String, Object...)
     */
    public RobotTelemetry addData(String caption, String format, Object... args) {
        telemetry.addData(caption, format, args);
        return this;
    }

    /**
     * Adds a formatted string item prefixed with a subassembly name.
     *
     * @param subassembly   The robot subsystem name.
     * @param caption       The caption to use.
     * @param format        The string by which the arguments are to be formatted.
     * @param args          The arguments to format.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addData(String, Object)
     * @see #addData(String, String, Object)
     * @see #addData(String, String, Object...)
     */
    public RobotTelemetry addData(String subassembly, String caption, String format, Object... args) {
        telemetry.addData(subassembly + " | " + caption, format, args);
        return this;
    }

    /**
     * Adds a standard key-value item to telemetry if {@link #debug} is {@code true}. Adds
     * a prefix showing it is a debug value: {@code "[DEBUG] Caption"}
     *
     * @param caption   The caption to use.
     * @param value     The value to display.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addDebugData(String, String, Object)
     * @see #addDebugData(String, String, Object...)
     * @see #addDebugData(String, String, String, Object...)
     */
    public RobotTelemetry addDebugData(String caption, Object value) {
        if (debug) telemetry.addData("[DEBUG] " + caption, value);
        return this;
    }

    /**
     * Adds a key-value item prefixed with a subassembly name if {@link #debug} is {@code true}.
     * Adds a prefix showing it is a debug value in addition to the standard subassembly prefix:
     * {@code "[DEBUG] Subassembly | Caption"}.
     *
     * @param subassembly   The robot subsystem name.
     * @param caption       The caption to use.
     * @param value         The value to display.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addDebugData(String, Object)
     * @see #addDebugData(String, String, Object...)
     * @see #addDebugData(String, String, String, Object...)
     */
    public RobotTelemetry addDebugData(String subassembly, String caption, Object value) {
        if (debug) telemetry.addData("[DEBUG] " + subassembly + " | " + caption, value);
        return this;
    }

    /**
     * Adds a formatted string item to telemetry if {@link #debug} is {@code true}. Adds
     * a prefix showing it is a debug value: {@code "[DEBUG] Caption"}
     *
     * @param caption   The caption to use.
     * @param format    The string by which the arguments are to be formatted.
     * @param args      The arguments to format.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addDebugData(String, Object)
     * @see #addDebugData(String, String, Object)
     * @see #addDebugData(String, String, String, Object...)
     */
    public RobotTelemetry addDebugData(String caption, String format, Object... args) {
        if (debug) telemetry.addData("[DEBUG] " + caption, format, args);
        return this;
    }

    /**
     * Adds a formatted string item prefixed with a subassembly name if {@link #debug} is {@code true}.
     * Adds a prefix showing it is a debug value in addition to the standard subassembly prefix:
     * {@code "[DEBUG] Subassembly | Caption"}.
     *
     * @param subassembly   The robot subsystem name.
     * @param caption       The caption to use.
     * @param format        The string by which the arguments are to be formatted.
     * @param args          The arguments to format.
     * @return a {@link RobotTelemetry} that can be used to update the value or append
     * {@link RobotTelemetry} methods.
     * @see #addDebugData(String, Object)
     * @see #addDebugData(String, String, Object)
     * @see #addDebugData(String, String, Object...)
     */
    public RobotTelemetry addDebugData(String subassembly, String caption, String format, Object... args) {
        if (debug) telemetry.addData("[DEBUG] " + subassembly + " | " + caption, format, args);
        return this;
    }


}
