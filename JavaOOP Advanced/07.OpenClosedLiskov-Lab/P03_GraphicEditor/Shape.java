package P03_GraphicEditor;

public class Shape implements Drawable {
    @Override
    public String draw() {
        return "I am a " + this.getClass().getSimpleName();
    }
}
