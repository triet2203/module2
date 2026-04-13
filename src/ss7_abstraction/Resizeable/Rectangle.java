package ss7_abstract.Resizeable;

public class Rectangle implements Resizeable {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }

    @Override
    public void resize(double percent) {
        width = width * (1 + percent / 100);
        height = height * (1 + percent / 100);
    }
}
