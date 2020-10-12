package td2;

public class TestPoint2D {
	public static void main(String[] args) {
    	Point2D p1, p2;

    	p1 = new Point2D(0, 0);
    	p1.display();

    	p2 = new Point2D(0, 3);
    	p2.display();

    	System.out.println("Distance = " + p2.distance(p1));

    	p1.move(1,1);
    	p1.display();

    	p2.move(1);
    	p2.display();
    	System.out.println("Distance = " + p2.distance(p1));

    }
}
