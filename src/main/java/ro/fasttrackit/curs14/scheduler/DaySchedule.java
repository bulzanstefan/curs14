package ro.fasttrackit.curs14.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySchedule {
    private final Day day;
    private final List<String> activities;

    public DaySchedule(Day day) {
        this.day = day;
        this.activities = new ArrayList<>();
    }

    public Day getDay() {
        return day;
    }

    public List<String> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public void addActivity(String activity) {
        this.activities.add(activity);
    }

    public void removeActivity(String activity) {
        this.activities.remove(activity);
    }
}
