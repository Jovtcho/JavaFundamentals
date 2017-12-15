package P03_GraphicEditor;

public class Circle extends Shape implements Drawable {
    @Override
    public String draw() {
        return "I am a " + this.getClass().getSimpleName();
    }
}
