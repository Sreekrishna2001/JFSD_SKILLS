package HW2;
import java.math.*;
public class Triangle extends Simple_Polygon {
public Triangle(Point a,Point b,Point c) {
	super(3);
	this.vertices[0]=a;
	this.vertices[1]=b;
	this.vertices[2]=c;
}
public double getPerimeter() {
	return Point.distance(this.vertices[0], this.vertices[1])
			+Point.distance(this.vertices[1],this.vertices[2])
			+Point.distance(this.vertices[1],this.vertices[0]);
}
public double getArea() {
	return Math.abs(((this.vertices[0].X * (this.vertices[1].Y - this.vertices[2].Y) 
			+ this.vertices[1].X * (this.vertices[2].Y - this.vertices[0].Y) 
			+ this.vertices[2].X * (this.vertices[0].Y - this.vertices[1].Y)) / 2));
}
}
