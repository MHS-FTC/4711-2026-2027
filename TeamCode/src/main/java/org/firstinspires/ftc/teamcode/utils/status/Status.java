package org.firstinspires.ftc.teamcode.utils.status;

public class Status {
    private RobotStatus current = RobotStatus.NONEXISTENT;
    private RobotStatus previous = RobotStatus.NONEXISTENT;

    public Status() {}

    public Status(RobotStatus status) {
        this.set(status);
    }

    public RobotStatus current() {
        return current;
    }

    public RobotStatus previous() {
        return previous;
    }

    public void set(RobotStatus status) {
        if (status != this.current) {
            this.previous   = this.current;
            this.current    = status;
        }
    }


}
