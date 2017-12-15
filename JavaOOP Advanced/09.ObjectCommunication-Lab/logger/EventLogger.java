package p01Logger.logger;

import p01Logger.enumerations.LogType;

public class EventLogger extends Logger {
    private static final String MESSAGE_FORMAT = "%s: %s" + System.lineSeparator();

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT || logType == LogType.TARGET) {
            System.out.printf(MESSAGE_FORMAT, logType.name(), message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}
