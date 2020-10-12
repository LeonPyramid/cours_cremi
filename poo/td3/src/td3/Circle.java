package td3;

public class Circle extends Shape2D {
	Point2D  center;
	double ray;
	
	public Circle() {
		this.ray = 0;
		this.center = new Point2D(0,0);
	}
	
	public Circle(double ray, Point2D center) {
		this.ray = ray;
		this.center = center.copy();
	}
	
	public Point2D getCenter() {
		return center;
	}
	public void setCenter(Point2D center) {
		this.center = center.copy();
	}
	public double getRay() {
		return ray;
	}
	public void setRay(double ray) {
		this.ray = ray;
	}
	
	public double perimeter() {
		return this.ray*2*Math.PI;
	}
	
	public double area() {
		return Math.pow(this.ray, 2)*Math.PI;
	}
	
	
	public void translate(double dx, double dy) {
		this.center.translate(dx, dy);
	}
	
	public void print() {
        System.out.println("Circle ( ray: " + this.ray + " center:");
        this.center.print();
        System.out.println (")");
    }
}
