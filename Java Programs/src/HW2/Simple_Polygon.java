package HW2;

public abstract class Simple_Polygon implements Polygon {
protected Point[] vertices;
public Simple_Polygon(int n) {
	if(n<3)throw new IllegalArgumentException();
	else
		this.vertices = new Point[n];
}
public int  getNumberOfSides() {
	return this.vertices.length;
}
public boolean isEquilateral(){
	double d1 = Point.distance(this.vertices[0], this.vertices[1]);
	for(int i=2;i<this.vertices.length;i++){
//		System.out.println();
		if(d1!=Point.distance(this.vertices[i], this.vertices[i-1]))return false;
	}
	return true;
}
}
