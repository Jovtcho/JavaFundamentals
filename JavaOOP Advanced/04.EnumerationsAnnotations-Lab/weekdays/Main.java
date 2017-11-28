package weekdays;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();

        weeklyCalendar.addEntry("Monday", "Working");
        weeklyCalendar.addEntry("Friday", "Sleeping");
        weeklyCalendar.addEntry("Sunday", "Drinking");
        weeklyCalendar.addEntry("Friday", "Sleeping more");
        weeklyCalendar.addEntry("Tuesday", "Working not much");

        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry entry : schedule) {
            System.out.println(entry);
        }
    }
}
