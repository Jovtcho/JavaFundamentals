package p01_system_resources;

import p01_system_resources.implementations.ConsoleOutputWriter;
import p01_system_resources.implementations.GreetingClockImpl;
import p01_system_resources.implementations.LocalTimeProvider;
import p01_system_resources.interfaces.GreatingClock;
import p01_system_resources.interfaces.OutputWriter;
import p01_system_resources.interfaces.TimeProvider;

public class Main {
    public static void main(String[] args) {
        TimeProvider timeProvider = new LocalTimeProvider();
        OutputWriter outputWriter = new ConsoleOutputWriter();

        GreatingClock greetingClock = new GreetingClockImpl(timeProvider, outputWriter);
        greetingClock.greeting();
    }
}
