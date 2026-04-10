package ss6_inheritance_polymorphism;

public class PointMain {
    public static void main(String[] args) {
        //Point
        Point p = new Point(2.0f, 3.0f);
        System.out.println(p);

        p.setX(4.0f);
        p.setY(6.0f);
        System.out.println("After setX, setY: " + p);

        p.setXY(5.0f, 7.0f);
        System.out.println("After setXY: " + p);

        float[] xy = p.getXY();
        System.out.println("getXY: (" + xy[0] + ", " + xy[1] + ")");

        //MovablePoint
        MovablePoint mp = new MovablePoint(1.0f, 2.0f, 3.0f, 4.0f);
        System.out.println(mp);

        mp.setSpeed(5.0f, 6.0f);
        System.out.println("After setSpeed: " + mp);

        float[] speed = mp.getSpeed();
        System.out.println("getSpeed: (" + speed[0] + ", " + speed[1] + ")");

        //move
        mp.move();
        System.out.println("After move 1: " + mp);

        mp.move();
        System.out.println("After move 2: " + mp);
    }
}
