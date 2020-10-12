package td3;

public class TestShape2D {
    public static void main(String[] args) {
        Point2D  p1 = new Point2D(1, 2);
        Point2D  p2 = new Point2D(4, 8);
        Point2D  p3 = new Point2D(4, 12);
        p1.print();
        p1.translate(5);
        p1.print();        
        Circle c = new Circle();
        c.print();
        c.setCenter(p1);
        c.print();
        c.setRay(10);
        Triangle t = new Triangle(p1,p2,p3);
        t.print();
        System.out.println("area = " + t.area());
        System.out.println();
        System.out.println();
        System.out.println();
        Shape2D s = new Point2D(1, 2);
        s.print();

        Point2D A = new Point2D(0, 0);
        Point2D B = new Point2D(5, 0);
        Point2D C = new Point2D(0, 5);
        Shape2D s2 = new Triangle(A, B, C);
        s.print(); 
        System.out.println();
        System.out.println();
        System.out.println();
        Shape2D tab[] = new Shape2D[4];
        tab[0] = p1;
        tab[1] = c;
        tab[2] = t;
        tab[3] = s2;
        for(int i = 0; i < 4;i ++) {
        	tab[i].print();
        	System.out.println("area = " + tab[i].area());
        	System.out.println();
        }
        
    }
}