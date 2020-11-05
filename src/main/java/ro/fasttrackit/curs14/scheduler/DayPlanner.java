package ro.fasttrackit.curs14.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayPlanner {
    private final List<DaySchedule> daySchedules = new ArrayList<>();

    public List<DaySchedule> getDaySchedules() {
        return Collections.unmodifiableList(daySchedules);
    }

    public List<String> getActivities(Day day) {
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay().equals(day)) {
                return Collections.unmodifiableList(schedule.getActivities());
            }
        }
        return List.of();
    }

    public void addActivity(Day day, String activity) {
        DaySchedule foundSchedule = null;
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay().equals(day)) {
                foundSchedule = schedule;
                break;
            }
        }
        if (foundSchedule == null) {
            foundSchedule = new DaySchedule(day);
            daySchedules.add(foundSchedule);
        }
        foundSchedule.addActivity(activity);
    }

    public void removeActivity(Day day, String activity) {
        boolean found = false;
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay().equals(day)) {
                if (schedule.getActivities().contains(activity)) {
                    schedule.removeActivity(activity);
                    found = true;
                } else {
                    throw new NoActivityException("Activity " + activity + " not found for day " + day);
                }
            }
        }
        if (!found) {
            throw new NoActivityException("No activities found for " + day);
        }
    }
}
