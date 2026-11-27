package org.firstinspires.ftc.teamcode.utils.controls;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.utils.Constants.ControlProfile;
import org.firstinspires.ftc.teamcode.utils.controls.Input.AxisBind;
import org.firstinspires.ftc.teamcode.utils.controls.Input.ButtonBind;
import org.firstinspires.ftc.teamcode.utils.controls.Input.Controller;

public class Controls {

    private final Gamepad gamepad1;
    private final Gamepad gamepad2;
    private ControlProfile profile;

    Controls(Gamepad gamepad1) {
        this(gamepad1, null, ControlProfile.SOLO_DRIVER());
    }
    public Controls(Gamepad gamepad1, Gamepad gamepad2) {
        this(gamepad1, gamepad2, ControlProfile.DUAL_DRIVER());
    }

    public Controls(Gamepad gamepad1, Gamepad gamepad2, ControlProfile profile) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.profile = profile;
    }

    public void setProfile(ControlProfile profile) {
        this.profile = profile;
    }

    public double getDriveAxial()   { return getAxis(profile.driveAxial); }
    public double getDriveLateral() { return getAxis(profile.driveLateral); }
    public double getDriveYaw()     { return getAxis(profile.driveYaw); }

    public boolean isSlowModeActive()       { return isPressed(profile.slowMode); }
    public boolean wasIntakeTogglePressed() { return wasJustPressed(profile.intakeToggle); }

    
    private Gamepad getGamepad(Controller controller) {
        return (controller == Controller.DRIVER_1) ? gamepad1 : gamepad2;
    }

    public double getAxis(@NonNull AxisBind bind) {
        Gamepad gp = getGamepad(bind.controller);

        double value = 0.0;

        switch (bind.axis) {
            case LEFT_X:        value = gp.left_stick_x; break;
            case LEFT_Y:        value = gp.left_stick_y; break;
            case RIGHT_X:       value = gp.right_stick_x; break;
            case RIGHT_Y:       value = gp.right_stick_y; break;
            case LEFT_TRIGGER:  value = gp.left_trigger; break;
            case RIGHT_TRIGGER: value = gp.right_trigger; break;
        }

        return (bind.inverted) ? -value : value;
    }

    public boolean isPressed(@NonNull ButtonBind bind) {
        Gamepad gp = getGamepad(bind.controller);

        switch (bind.button) {
            case A:                  return gp.a;
            case B:                  return gp.b;
            case X:                  return gp.x;
            case Y:                  return gp.y;
            case DPAD_UP:            return gp.dpad_up;
            case DPAD_DOWN:          return gp.dpad_down;
            case DPAD_LEFT:          return gp.dpad_left;
            case DPAD_RIGHT:         return gp.dpad_right;
            case LEFT_BUMPER:        return gp.left_bumper;
            case RIGHT_BUMPER:       return gp.right_bumper;
            case LEFT_STICK_BUTTON:  return gp.left_stick_button;
            case RIGHT_STICK_BUTTON: return gp.right_stick_button;
            default:                 return false;
        }
    }

    public boolean wasJustPressed(@NonNull ButtonBind bind) {
        Gamepad gp = getGamepad(bind.controller);

        switch (bind.button) {
            case A:                  return gp.aWasPressed();
            case B:                  return gp.bWasPressed();
            case X:                  return gp.xWasPressed();
            case Y:                  return gp.yWasPressed();
            case DPAD_UP:            return gp.dpadUpWasPressed();
            case DPAD_DOWN:          return gp.dpadDownWasPressed();
            case DPAD_LEFT:          return gp.dpadLeftWasPressed();
            case DPAD_RIGHT:         return gp.dpadRightWasPressed();
            case LEFT_BUMPER:        return gp.leftBumperWasPressed();
            case RIGHT_BUMPER:       return gp.rightBumperWasPressed();
            case LEFT_STICK_BUTTON:  return gp.leftStickButtonWasPressed();
            case RIGHT_STICK_BUTTON: return gp.rightStickButtonWasPressed();
            default:                 return false;
        }
    }

    public boolean wasJustReleased(@NonNull ButtonBind bind) {
        Gamepad gp = getGamepad(bind.controller);

        switch (bind.button) {
            case A:                  return gp.aWasReleased();
            case B:                  return gp.bWasReleased();
            case X:                  return gp.xWasReleased();
            case Y:                  return gp.yWasReleased();
            case DPAD_UP:            return gp.dpadUpWasReleased();
            case DPAD_DOWN:          return gp.dpadDownWasReleased();
            case DPAD_LEFT:          return gp.dpadLeftWasReleased();
            case DPAD_RIGHT:         return gp.dpadRightWasReleased();
            case LEFT_BUMPER:        return gp.leftBumperWasReleased();
            case RIGHT_BUMPER:       return gp.rightBumperWasReleased();
            case LEFT_STICK_BUTTON:  return gp.leftStickButtonWasReleased();
            case RIGHT_STICK_BUTTON: return gp.rightStickButtonWasReleased();
            default:                 return false;
        }
    }
}
