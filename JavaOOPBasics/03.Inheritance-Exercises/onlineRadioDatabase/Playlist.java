package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    Playlist() {
        this.setSongs();
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }

    private void setSongs() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public String getPlayListLength() {
        int totalSongsMinutes = this.songs.stream().mapToInt(Song::getMinutes).sum();
        int totalSongSeconds = this.songs.stream().mapToInt(Song::getSeconds).sum();
        int totalSeconds = totalSongsMinutes * 60 + totalSongSeconds;

        int playListHours = totalSeconds / 3600;
        int playListMinutes = (totalSeconds % 3600) / 60;
        int playListSeconds = totalSeconds % 60;

        StringBuilder sb = new StringBuilder();
        //0h 7m 47s
        sb.append(playListHours).append("h ")
                .append(playListMinutes).append("m ")
                .append(playListSeconds).append("s");
        return sb.toString();
    }
}
