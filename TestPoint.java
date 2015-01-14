import java.util.ArrayList;

class Point {
	public int x;
	public int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}

	public String toString() {

		return ("(" + this.x + "," + this.y + ")");
	}
}

public class TestPoint {
	public static void main(String args[]) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 4);
		Point p4 = new Point(35, 36);
		ArrayList<Point> al = new ArrayList<Point>();
		al.add(p1);
		al.add(p2);
		al.add(p3);
		al.add(p4);
		System.out.println(al.toString());
		System.out.println(p1.x);
	}
}
