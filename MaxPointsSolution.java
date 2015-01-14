/**
 * Definition for a Point1.
 * class Point1 {
 *     int x;
 *     int y;
 *     Point1() { x = 0; y = 0; }
 *     Point1(int a, int b) { x = a; y = b; }
 * }
 */
//Given n Point1s on a 2D plane, find the maximum number of Point1s that lie on the same straight line.
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class Point1 {
	static int size = 0;
	public int x;
	public int y;

	Point1() {
		x = 0;
		y = 0;
		size++;
	}

	Point1(int a, int b) {
		x = a;
		y = b;
		size++;
	}
}

public class MaxPointsSolution {
	public int maxPoint1s(Point1[] Point1s) {
		int n = Point1.size;
		if (n <= 2) {
			return n;
		}
		Map<Double, Integer> dictionary = new Hashtable<Double, Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					Point1 p1 = Point1s[i];
					Point1 p2 = Point1s[j];
					// int xcord;
					double slope = 1.0;
						try {
							slope = (p2.y - p1.y) / (p2.x - p1.x);
						} catch (Exception e) {
							System.out.println(e);
						}
					if (dictionary.containsKey(slope)) {
						Integer val = dictionary.get(slope);
						dictionary.put(slope, val + 1);
					} else
						dictionary.put(slope, 1);
				}
			}
		}
		List<Double> maxKeyList = new ArrayList<Double>();
		Integer maxValue = Integer.MIN_VALUE;
		for (Map.Entry<Double, Integer> entry : dictionary.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				maxKeyList.add(entry.getKey());
			}
		}

		return maxValue;

	}

	public static void main(String args[]) {
		Point1[] array = { new Point1(1, 1), new Point1(2, 2),
				new Point1(2, 3), };
		// int len = array.size();
		// System.out.println(Point1.size);
		MaxPointsSolution ms = new MaxPointsSolution();
		// System.out.println(array[0].x);

		System.out.println(ms.maxPoint1s(array));
	}

}