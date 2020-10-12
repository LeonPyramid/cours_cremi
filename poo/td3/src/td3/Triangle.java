package td3;

public class Triangle extends Shape2D {
	Point2D p1,p2,p3;

	
	public Triangle(Point2D p1,Point2D p2,Point2D p3) {
		this.p1 = p1.copy();
		this.p2 = p2.copy();
		this.p3 = p3.copy();
	}
	public Point2D getP1() {
		return p1;
	}

	public void setP1(Point2D p1) {
		this.p1 = p1.copy();
	}

	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2 = p2.copy();
	}

	public Point2D getP3() {
		return p3;
	}

	public void setP3(Point2D p3) {
		this.p3 = p3.copy();
	}
	
	
	public void translate(double dx, double dy) {
		this.p1.translate(dx, dy);
		this.p2.translate(dx, dy);
		this.p3.translate(dx, dy);
	}
	
	public void print() {
		System.out.println("Triangle ( p1: ");
        this.p1.print();
        System.out.println("p2:");
        this.p2.print();
        System.out.println("p3:");
        this.p3.print();
        System.out.println (")");
	}
	
	public double perimeter() {
		return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
	}
	
	
	public double area() {
		return Math.abs((p1.getX()*(p2.getY()-p3.getY())+p2.getX()*(p3.getY()-p1.getY())+p3.getX()*(p1.getY()-p2.getY()))/2);
	}
}
