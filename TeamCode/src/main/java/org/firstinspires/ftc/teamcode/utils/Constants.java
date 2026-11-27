package org.firstinspires.ftc.teamcode.utils;

import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.utils.controls.Input;

public class Constants {
    public static class ControlProfile {
        public Input.AxisBind driveAxial;
        public Input.AxisBind driveLateral;
        public Input.AxisBind driveYaw;
        public Input.ButtonBind slowMode;
        public Input.ButtonBind intakeToggle;

        @NonNull
        public static ControlProfile SOLO_DRIVER() {
            ControlProfile p = new ControlProfile();

            p.driveAxial = new Input.AxisBind(Input.Controller.DRIVER_1, Input.Axis.LEFT_Y, true);
            p.driveLateral = new Input.AxisBind(Input.Controller.DRIVER_1, Input.Axis.LEFT_X);
            p.driveYaw = new Input.AxisBind(Input.Controller.DRIVER_1, Input.Axis.RIGHT_X);
            p.slowMode = new Input.ButtonBind(Input.Controller.DRIVER_1, Input.Button.RIGHT_BUMPER);
            p.intakeToggle = new Input.ButtonBind(Input.Controller.DRIVER_1, Input.Button.A);

            return p;
        }

        @NonNull
        public static ControlProfile DUAL_DRIVER() {
            ControlProfile p = SOLO_DRIVER();

            p.intakeToggle = new Input.ButtonBind(Input.Controller.DRIVER_2, Input.Button.A);

            return p;
        }


    }
}
