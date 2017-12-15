package P03_GraphicEditor;

public class Rectangle extends Shape {
    @Override
    public String draw() {
        return "I am a " + this.getClass().getSimpleName();
    }
}
