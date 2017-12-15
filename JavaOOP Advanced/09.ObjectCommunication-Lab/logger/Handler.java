package p01Logger.logger;

import p01Logger.enumerations.LogType;

public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
