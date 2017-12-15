package P03_GraphicEditor;

public class GraphicEditor {
    public void drawShape(Drawable shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Drawable circle = new Circle();
        Drawable rectangle = new Rectangle();
        Drawable shape = new Shape();
        Drawable square = new Square();

        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(circle);
        graphicEditor.drawShape(rectangle);
        graphicEditor.drawShape(shape);
        graphicEditor.drawShape(square);
    }
}
