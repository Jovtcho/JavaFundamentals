package P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
    @Test
    public void getRectangleSidesTest() {
        Rectangle rect = new Rectangle(5, 10);
        Assert.assertEquals(5, rect.getWidth());
        Assert.assertEquals(10, rect.getHeight());
    }

    @Test
    public void getRectangleAreaTest() {
        Rectangle rect = new Rectangle(10,5);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void getSquareSidesTest() {
        Rectangle square = new Square(10);
        Assert.assertEquals(10, square.getWidth());
        Assert.assertEquals(10, square.getHeight());
    }

    @Test
    public void getSquareAreaTest() {
        Rectangle square = new Square(10);
        Assert.assertEquals(100, square.getArea());
    }
}
