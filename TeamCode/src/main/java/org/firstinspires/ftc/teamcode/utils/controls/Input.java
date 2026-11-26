package org.firstinspires.ftc.teamcode.utils.controls;

public class Input {
    public enum Controller {DRIVER_1, DRIVER_2}

    public enum Axis {
        LEFT_X, LEFT_Y, RIGHT_X, RIGHT_Y,
        LEFT_TRIGGER, RIGHT_TRIGGER
    }

    public enum Button {
        A, B, X, Y,
        DPAD_UP, DPAD_DOWN, DPAD_LEFT, DPAD_RIGHT,
        LEFT_BUMPER, RIGHT_BUMPER,
        LEFT_STICK_BUTTON, RIGHT_STICK_BUTTON
    }

    public static class AxisBind {
        public final Controller controller;
        public final Axis axis;
        public final boolean inverted;

        public AxisBind(Controller controller, Axis axis, boolean inverted) {
            this.controller = controller;
            this.axis = axis;
            this.inverted = inverted;
        }
    }

    public static class ButtonBind {
        public final Controller controller;
        public final Button button;

        public ButtonBind(Controller controller, Button button) {
            this.controller = controller;
            this.button = button;
        }
    }
}
