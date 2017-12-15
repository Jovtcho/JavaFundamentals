package P03_GraphicEditor;

public class Square extends Shape implements Drawable {
    @Override
    public String draw() {
        return "I am a " + this.getClass().getSimpleName();
    }
}
