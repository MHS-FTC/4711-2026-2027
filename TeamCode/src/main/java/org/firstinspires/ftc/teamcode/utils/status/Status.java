package org.firstinspires.ftc.teamcode.utils.status;

public class Status {
    private RobotStatus current = RobotStatus.NONEXISTANT;
    private RobotStatus previous = RobotStatus.NONEXISTANT;

    public Status() {
    }

    public RobotStatus current() {
        return current;
    }

    public RobotStatus previous() {
        return previous;
    }

    public void set(RobotStatus status) {
        if (status != this.current) {
            this.previous = this.current;
            this.current = status;
        }
    }


}
