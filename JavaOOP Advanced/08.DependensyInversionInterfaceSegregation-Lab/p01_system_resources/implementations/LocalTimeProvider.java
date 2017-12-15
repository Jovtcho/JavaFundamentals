package p01_system_resources.implementations;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider {
    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
