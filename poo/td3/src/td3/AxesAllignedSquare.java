package td3;

public class AxesAllignedSquare extends Shape2D {
	private Point2D corner;
	double side;
	
	
	public Point2D getP1() {
		return corner;
	}

	public void setP1(Point2D p1) {
		this.corner = p1.copy();
	}


	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}


	public AxesAllignedSquare(Point2D p1,double side) {
		this.corner = p1.copy();
		this.side = side;
	}
	
	public void translate(double dx, double dy) {
		this.corner.translate(dx, dy);
	}
	
	
	
	public double perimeter() {
		return 4*(this.side);
	}
	
	public double area() {
		return this.side*this.side;
	}
	
	public void print() {
        System.out.println("Rectangle ( p1: ");
        this.corner.print();
        System.out.println(" side:" + this.side + ")");
    }
}
