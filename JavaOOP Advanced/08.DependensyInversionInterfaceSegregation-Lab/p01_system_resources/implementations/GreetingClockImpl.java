package p01_system_resources.implementations;

import p01_system_resources.interfaces.GreatingClock;
import p01_system_resources.interfaces.OutputWriter;
import p01_system_resources.interfaces.TimeProvider;

public class GreetingClockImpl implements GreatingClock {

    private TimeProvider time;
    private OutputWriter outputWriter;

    public GreetingClockImpl(TimeProvider time, OutputWriter outputWriter) {
        this.time = time;
        this.outputWriter = outputWriter;
    }

    @Override
    public void greeting() {
        if (time.getHour() < 12) {
            outputWriter.writeLine("Good morning...");
        } else if (time.getHour() < 18) {
            outputWriter.writeLine("Good afternoon...");
        } else {
            outputWriter.writeLine("Good evening...");
        }
    }
}
