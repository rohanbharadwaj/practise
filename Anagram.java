import java.util.Scanner;

public class Anagram {
	public static void arraySwap(char a[],int x,int y)
	{
	        char temp = a[x];
	        a[x]=a[y];
	        a[y]=temp;
	}
	public static void main (String args[]) {
		
		Scanner r = new Scanner(System.in);
		System.out.print("Enter a string:"); 
		String s = r.nextLine(); 
		char text[] = s.toCharArray();		
		System.out.println("Here are all the anagrams of " + s);
		makeAnagram(text, 0); 
		r.close();
	} 

	static void makeAnagram(char[] a, int i) {
		if (i == a.length-1)  printArray(a);
		else {
			for (int j=i; j< a.length; j++) {
				arraySwap(a, i, j);
				makeAnagram(a, i+1);
				arraySwap(a, i, j);
			}
		}
	}
	
	static void printArray(char [] a) {
		for (int i=0; i< a.length; i++) System.out.print(a[i]); 
		System.out.println();
	} 
}
