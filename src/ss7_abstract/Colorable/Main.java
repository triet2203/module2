package ss7_abstract.Colorable;

public class Main {
    public static void main(String[] args) {
        Object[] shapes = new Object[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(4);

        for (Object shape : shapes) {
            if(shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println("Area of Circle: " + c.getArea());
            }

            if(shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.println("Area of Rectangle: " + r.getArea());
            }

            if(shape instanceof Square) {
                Square sq = (Square) shape;
                System.out.println("Area Square: " + sq.getArea());
            }

            if(shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
