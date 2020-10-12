package td2;

class Circle {
    private Point2D center;
    public Point2D getCenter() {
		return center;
	}

	public void setCenter(Point2D centre) {
		this.center = centre;
	}
	private double ray;

	public double getRay() {
		return ray;
	}

	public void setRay(double rayon) {
		this.ray = rayon;
	}


    Circle (Point2D centre, double rayon) {
    	this.center = new Point2D();
    	this.center.setX(centre.getX());
    	this.center.setY(centre.getY());
    	this.ray = rayon;
    }
    
    double perimeter() {
    	return 2 * this.ray * Math.PI;
    }
    
    void move(double dx, double dy) {
    	this.center.move(dx, dy);
    }
    
    void move(double delta) {
    	this.center.move(delta);
    }
    double surface() {
    	return Math.PI * ray*ray;
    }

    boolean isIn(Point2D p) {
    	double distance = p.distance(center);
    	return distance <= ray;
    }

}
