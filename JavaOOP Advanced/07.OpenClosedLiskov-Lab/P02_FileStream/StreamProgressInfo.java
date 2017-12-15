package P02_FileStream;

public class StreamProgressInfo {
    private Stream stream;

    public StreamProgressInfo(Stream stream) {
        this.stream = stream;
    }

    public int calculateCurrentPercent() {
        return (this.stream.getBytesSent() * 100) / this.stream.getLength();
    }

    //public int calculateCurrentPercent() {
    //    return (this.file.getBytesSent() * 100) / this.file.getLength();
    //}

    public static void main(String[] args) {
        Stream file = new File("FirstFile", 20, 30);
        Stream music = new Music("Pesho", "My album", 10, 20);
        Stream video = new Video("Misho", 10, 10);
        StreamProgressInfo streamProgressInfoFile = new StreamProgressInfo(file);
        StreamProgressInfo streamProgressInfoMusic = new StreamProgressInfo(music);
        StreamProgressInfo streamProgressInfoVideo = new StreamProgressInfo(video);

        System.out.println(streamProgressInfoFile.calculateCurrentPercent());
        System.out.println(streamProgressInfoMusic.calculateCurrentPercent());
        System.out.println(streamProgressInfoVideo.calculateCurrentPercent());
    }
}
