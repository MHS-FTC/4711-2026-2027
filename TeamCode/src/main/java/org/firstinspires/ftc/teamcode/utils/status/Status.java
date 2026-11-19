package org.firstinspires.ftc.teamcode.utils.status;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private volatile List<RobotStatus> history = new ArrayList<>();

    public Status() {
    }

    public RobotStatus current() {
        return !history.isEmpty() ? history.get(history.size() - 1) : RobotStatus.NONEXISTANT;
    }

    public RobotStatus previous() {
        return (history.size() >= 2) ? history.get(history.size() - 2) : RobotStatus.NONEXISTANT;
    }

    public void set(RobotStatus status) {
        this.history.add(status);
    }


}
