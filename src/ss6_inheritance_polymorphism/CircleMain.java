package ss6_inheritance_polymorphism;

public class CircleMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "blue");
        System.out.println("Circle: ");
        System.out.println(circle.toString());
        System.out.println("Area: " + circle.getArea());

        Cylinder cylinder = new Cylinder(6.0, "red", 10.0);
        System.out.println("Cylinder: ");
        System.out.println(cylinder.toString());
        System.out.println("Area: " + cylinder.getArea());
        System.out.println("Volume: " + cylinder.getVolume());
    }
}
