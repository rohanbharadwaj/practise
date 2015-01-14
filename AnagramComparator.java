import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {

	public String sortChars(String s) {

		char[] content = s.toCharArray();

		Arrays.sort(content);

		return new String(content);

	}

	public int compare(String s1, String s2) {

		return sortChars(s1).compareTo(sortChars(s2));
	}

	public static void main(String args[]) {
		String[] array = { "a", "b", "abc", "def", "cba", "fed" };
		Arrays.sort(array, new AnagramComparator());
		for (String n : array)
			System.out.println(n);

	}
}