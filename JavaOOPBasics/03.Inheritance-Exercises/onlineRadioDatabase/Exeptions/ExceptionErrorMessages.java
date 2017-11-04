package onlineRadioDatabase.Exeptions;

public final class ExceptionErrorMessages {
    public static final String INVALID_ARTISTNAME_EXCEPTION = "Artist name should be between 3 and 20 symbols.";
    public static final String INVALID_SONGNAME_EXCEPTION = "Song name should be between 3 and 30 symbols.";
    public static final String INVALID_SONGLENGTH_EXCEPTION = "Invalid song length.";
    public static final String INVALID_SONGMINUTES_EXCEPTION = "Song minutes should be between 0 and 14.";
    public static final String INVALID_SONGSECONDS_EXCEPTION = "Song seconds should be between 0 and 59.";

    private ExceptionErrorMessages() {
    }
}