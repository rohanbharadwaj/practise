public class BitTest {
	static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	int setBit(int num, int i) {
		return num | (1 << i);
	}

	public static void main(String args[]) {
		System.out.println(getBit(7, 3));
	}

}