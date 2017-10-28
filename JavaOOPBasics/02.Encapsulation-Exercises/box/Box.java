package box;

public final class Box {
    //length, width, height
    private Box() {
    }

    public static double getSurfaceArea(double length, double width, double height) {
        return 2 * (length * width + length * height + width * height);
    }

    public static double getLateralSurfaceArea(double length, double width, double height) {
        return 2 * (length * height + width * height);
    }

    public static double getVolume(double length, double width, double height) {
        return length * width * height;
    }
}
