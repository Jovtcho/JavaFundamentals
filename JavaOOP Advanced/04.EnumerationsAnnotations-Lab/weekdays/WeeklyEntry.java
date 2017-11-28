package weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public final static Comparator<WeeklyEntry> BY_WEEKDAY = getCompByDay();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Weekday.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

   //public int compareTo(WeeklyEntry other) {
   //    //return this.weekday.ordinal() - other.weekday.ordinal();
   //    return Integer.compare(this.weekday.ordinal(), other.weekday.ordinal());
   //}

    private static Comparator<WeeklyEntry> getCompByDay() {
        return (e1, e2) -> e1.weekday.compareTo(e2.weekday);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday, this.notes);
    }
}
