package P02_FileStream;

public class Video implements Stream {
    private String editor;
    private int length;
    private int bytesSent;

    public Video(String editor, int length, int bytesSent) {
        this.editor = editor;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getBytesSent() {
        return bytesSent;
    }
}
