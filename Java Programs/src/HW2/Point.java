package HW2;
import java.math.*;
public class Point {
public double X,Y;
Point(double x,double y){
	this.X = x;
	this.Y = y;
}
public static double  distance(Point a,Point b) {
	return Math.sqrt(Math.pow(a.X-b.X, 2)+Math.pow(a.Y-b.Y, 2));
}
}
