package ss7_abstract.Colorable;

public class Square implements Colorable{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
