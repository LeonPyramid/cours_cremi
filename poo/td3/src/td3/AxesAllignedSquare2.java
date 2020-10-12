package td3;

public class AxesAllignedSquare2 extends AxesAllignedRectangle {

	public AxesAllignedSquare2(Point2D p1, Point2D p2) {
		super(p1, p2);
		if(this.xLen()!= this.yLen()) {
			System.err.println("This is not a square!");
		}
	}
	
	public AxesAllignedSquare2(Point2D p, double side) {
		super(p,new Point2D(p.getX()+side,p.getY()+side));
	}
	
	public double getSide() {
		return this.xLen();
	}

	public void setSide(double side) {
		double diff = side - this.xLen();
		
	}
}
