package ss7_abstraction.Resizeable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(3.0, 5.0);
        shapes[2] = new Square(4.0);

        for (Resizeable shape : shapes) {
            double percent = random.nextInt(100) + 1;
            if(shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println("Circle: ");
                System.out.println("Before: " + c.getArea());
                shape.resize(percent);
                System.out.println("After: " + c.getArea());
        }

            if(shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.println("Rectangle:");
                System.out.println("Before: " + r.getArea());
                shape.resize(percent);
                System.out.println("After: " + r.getArea());
            }

            if(shape instanceof Square) {
                Square sq = (Square) shape;
                System.out.println("Square:");
                System.out.println("Before: " + sq.getArea());
                shape.resize(percent);
                System.out.println("After: " + sq.getArea())    ;
            }

            System.out.println("Resize percent: " + percent + "%");

        }
    }
}
