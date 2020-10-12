package td2;

public class Square {
	Rectangle square;
	
	
	public Point2D getP() {
		return this.square.getP1();
	}

	public void setP1(Point2D p1) {
		this.square.setP1(p1);
	}


	public double getSide() {
		return Math.abs(this.square.getP1().getX() - this.square.getP2().getX());
	}

	public void setSide(double side) {
		Point2D p = new Point2D();
		p.setX(this.square.getP1().getX()+side);
		p.setY(this.square.getP1().getY()+side);
		this.square.setP2(p);
	}


	Square(Point2D p1,double side) {
		this.square.setP1(p1);
		Point2D p = new Point2D();
		p.setX(this.square.getP1().getX()+side);
		p.setY(this.square.getP1().getY()+side);
		this.square.setP2(p);
	}
	
	void move(double dx, double dy) {
		this.square.move(dx, dy);
	}
	
	void move(double delta) {
		this.square.move(delta);
	}
	
	double perimeter() {
		return this.square.perimeter();
	}
	
	double surface() {
		return this.square.surface();
	}
	
	boolean isIn(Point2D p) {
		
		return this.square.isIn(p);
	}
}
