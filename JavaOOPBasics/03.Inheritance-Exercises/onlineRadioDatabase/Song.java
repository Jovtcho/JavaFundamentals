package onlineRadioDatabase;

import onlineRadioDatabase.Exeptions.*;

public class Song {
    //<artist name>;<song name>;<minutes:seconds>
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    private void setArtistName(String artistName) {
        //Artist name should be between 3 and 20 symbols.
        if (3 > artistName.length() || artistName.length() > 20) {
            throw new InvalidArtistNameException(ExceptionErrorMessages.INVALID_ARTISTNAME_EXCEPTION);
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        //Song name should be between 3 and 30 symbols.
        if (3 > songName.length() || songName.length() > 30) {
            throw new InvalidSongNameException(ExceptionErrorMessages.INVALID_SONGNAME_EXCEPTION);
        }
        this.songName = songName;
    }

    public int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(int minutes) {
        //Song minutes should be between 0 and 14.
        if (0 > minutes || minutes > 14) {
            throw new InvalidSongMinutesException(ExceptionErrorMessages.INVALID_SONGMINUTES_EXCEPTION);
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds) {
        //Song seconds should be between 0 and 59.
        if (0 > seconds || seconds > 59) {
            throw new InvalidSongSecondsException(ExceptionErrorMessages.INVALID_SONGSECONDS_EXCEPTION);
        }
        this.seconds = seconds;
    }
}
