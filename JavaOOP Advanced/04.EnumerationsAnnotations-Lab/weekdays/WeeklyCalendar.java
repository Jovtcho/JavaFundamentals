package weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entryList;

    public WeeklyCalendar() {
        this.entryList = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        WeeklyEntry entry = new WeeklyEntry(weekday, notes);
        this.entryList.add(entry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        //this.entryList.sort(WeeklyEntry::compareTo);
        this.entryList.sort(WeeklyEntry.BY_WEEKDAY);
        return this.entryList;
    }
}
