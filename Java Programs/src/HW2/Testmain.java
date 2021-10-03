package HW2;

public class Testmain {
public static void main(String[] args) {
	Point p1 = new Point(0,-1);
	Point p2 = new Point(2,1);
	Point p3 = new Point(0,3);
	Triangle t = new Triangle(p1,p2,p3);
//	System.out.println(t.isEquilateral());
	System.out.println(Point.distance(p1, p2));
	System.out.println(Point.distance(p2, p3));
	System.out.println(Point.distance(p1, p3));
	System.out.println(t.getArea());
}
}
