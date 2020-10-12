package td3;

public class Point2D extends Shape2D {
	double x, y;
    
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2D(Point2D p){
        this(p.x, p.y);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void translate(double dx, double dy) {
        x = x + dx;
        y = y + dy;
    }

    public void print() {
        System.out.println( "Point2D (" + x + ", "  + y + ")");
    }

    public double distance(Point2D p){
        double d1 = p.x - x;
        double d2 = p.y - y;
        return Math.sqrt(d1*d1 + d2*d2);
   }
    
    public Point2D copy() {
    	Point2D npt = new Point2D(this.x,this.y);
    	return npt;
    	
    }
}
