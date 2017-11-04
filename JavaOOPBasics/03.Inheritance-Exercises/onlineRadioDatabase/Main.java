package onlineRadioDatabase;

import onlineRadioDatabase.Exeptions.ExceptionErrorMessages;
import onlineRadioDatabase.Exeptions.InvalidSongException;
import onlineRadioDatabase.Exeptions.InvalidSongLengthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int songsCount = Integer.parseInt(br.readLine());
        Playlist myPlayList = new Playlist();

        for (int i = 0; i < songsCount; i++) {
            String[] tokens = br.readLine().split(";");
            String artistName = tokens[0];
            String songName = tokens[1];
            String[] songLengthTokens = tokens[2].split(":");
            int songMinutes = 0;

            int songSeconds = 0;
            try {
                songMinutes = Integer.parseInt(songLengthTokens[0]);
                songSeconds = Integer.parseInt(songLengthTokens[1]);
            } catch (IllegalArgumentException ile) {
                System.out.println(ExceptionErrorMessages.INVALID_SONGLENGTH_EXCEPTION);
                continue;
            }

            try {
                Song song = new Song(artistName, songName, songMinutes, songSeconds);
                myPlayList.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", myPlayList.getSongs().size());
        System.out.printf("Playlist length: %s%n", myPlayList.getPlayListLength());
    }
}
