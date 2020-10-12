package td2;

public class Rectangle {
	private Point2D p1,p2;
	
		
	public Point2D getP1() {
		return p1;
	}

	public void setP1(Point2D p1) {
		this.p1.copy(p1);
	}


	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2.copy(p2);
	}


	Rectangle(Point2D p1,Point2D p2) {
		this.p1.copy(p1);
		this.p2.copy(p2);
	}
	
	void move(double dx, double dy) {
		this.p1.move(dx, dy);
		this.p2.move(dx, dy);
	}
	
	void move(double delta) {
		this.p1.move(delta);
		this.p2.move(delta);
	}
	
	double xLen() {
		return Math.abs(p1.getX()-p2.getX());
	}
	
	double yLen() {
		return Math.abs(p1.getX()-p2.getX());
	}
	
	double perimeter() {
		return 2*(this.xLen()+this.yLen());
	}
	
	double surface() {
		return this.xLen()*this.yLen();
	}
	
	boolean isIn(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		return ((x>=this.p1.getX()&&x<=this.p2.getX())||(x<=this.p1.getX()&&x>=this.p2.getX()))&&
				((y>=this.p1.getY()&&y<=this.p2.getY())||(y<=this.p1.getY()&&y>=this.p2.getY()));
	}
}
