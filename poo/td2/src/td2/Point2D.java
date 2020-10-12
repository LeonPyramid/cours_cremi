package td2;

public class Point2D {
	private double x, y;
	
	public double getX(){
		return this.x;
	}
	
	public void setX(double v) {
		this.x = v;
	}
	public void setY(double v) {
		this.y = v;
	}	
	public double getY() {
		return this.y;
	}

    Point2D() {
    	// ne fait rien
    }

    Point2D(double x, double y) {
    	this.x = x;
    	this.y = y;
    }

    void move(double dx, double dy) {
    	x += dx;
    	y += dy;
    }

    void move(double delta) {
    	move(delta, delta);
    }

    double distance(Point2D p) {
    	double d1 = p.x - x;
    	double d2 = p.y - y;
    	return Math.sqrt(d1*d1 + d2*d2);
    }
    
    void display() {
    	System.out.println("Point : (" + this.x + ", " + this.y + ")");
    }
    
    void copy(Point2D p) {
    	this.x = p.getX();
    	this.y = p.getY();
    }

}
