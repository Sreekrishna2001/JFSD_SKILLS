package HW2;

public class Quadrilateral extends Simple_Polygon{
public Quadrilateral(Point a,Point b,Point c,Point d) {
	super(4);
	this.vertices[0] = a;
	this.vertices[1] = b;
	this.vertices[2] = c;
	this.vertices[3] = d;
}
public double getPerimeter() {
	return Point.distance(this.vertices[0], this.vertices[1])
			+Point.distance(this.vertices[1],this.vertices[2])
			+Point.distance(this.vertices[2],this.vertices[3])
			+Point.distance(this.vertices[3], this.vertices[1]);

}
public double getArea() {
	Triangle t1 = new Triangle(this.vertices[0],this.vertices[1],this.vertices[2]);
	Triangle t2 = new Triangle(this.vertices[0],this.vertices[2],this.vertices[3]);
	return t1.getArea()+t2.getArea();
}
}
