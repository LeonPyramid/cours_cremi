package td3;

public class AxesAllignedRectangle extends Shape2D {
	private Point2D p1,p2;
	
	
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


	public AxesAllignedRectangle(Point2D p1,Point2D p2) {
		this.p1 = p1.copy();
		this.p2 = p2.copy();
	}
	
	public void translate(double dx, double dy) {
		this.p1.translate(dx, dy);
		this.p2.translate(dx, dy);
	}
	
	
	public double xLen() {
		return Math.abs(p1.getX()-p2.getX());
	}
	
	public double yLen() {
		return Math.abs(p1.getX()-p2.getX());
	}
	
	public double perimeter() {
		return 2*(this.xLen()+this.yLen());
	}
	
	public double area() {
		return this.xLen()*this.yLen();
	}
	
	
	public void print() {
        System.out.println("Rectangle ( p1: ");
        this.p1.print();
        System.out.println(" p2:");
        this.p2.print();
        System.out.println (")");
    }

}
