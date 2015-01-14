//Reference : http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Heapsort
import java.util.Scanner;

public class HeapSort
{
	
	public static void arraySwap(int a[],int x,int y)
	{
	        int temp = a[x];
	        a[x]=a[y];
	        a[y]=temp;
	}
	
public static void heapSort(int[] array) {
    
    for (int heapsize=0; heapsize<array.length; heapsize++) {
        
        int n = heapsize; // the index of the inserted int
        while (n > 0) { // until we reach the root of the heap
            int p = (n-1)/2; // the index of the parent of n
            if (array[n] > array[p]) { // child is larger than parent
                arraySwap(array, n, p); // swap child with parent
                n = p; // check parent
            }
            else // parent is larger than child
                break; // all is good in the heap
        }
    }

    for (int heapsize=array.length; heapsize>0;) {
        arraySwap(array, 0, --heapsize); // swap root with the last heap element
        int n = 0; // index of the element being moved down the tree
        while (true) {
            int left = (n*2)+1;
            if (left >= heapsize) // node has no left child
                break; // reached the bottom; heap is heapified
            int right = left+1;
            if (right >= heapsize) { // node has a left child, but no right child
                if (array[left] > array[n]) // if left child is greater than node
                    arraySwap(array, left, n); // swap left child with node
                break; // heap is heapified
            }
            if (array[left] > array[n]) { // (left > n)
                if (array[left] > array[right]) { // (left > right) & (left > n)
                    arraySwap(array, left, n);
                    n = left; continue; // continue recursion on left child
                } else { // (right > left > n)
                    arraySwap(array, right, n);
                    n = right; continue; // continue recursion on right child
                }
            } else { // (n > left)
                if (array[right] > array[n]) { // (right > n > left)
                    arraySwap(array, right, n);
                    n = right; continue; // continue recursion on right child
                } else { // (n > left) & (n > right)
                    break; // node is greater than both children, so it's heapified
                }
              }
            }
        }
    }
public static void main(String args[])
{
	Scanner scanner = null;
	int arr[];
        int T,i=0;
        try{
	        scanner = new Scanner(System.in);
	        T = scanner.nextInt();
	        arr = new int[T];
	        while (T-->0) {
	          if (scanner.hasNextInt()) {
	           arr[i]=scanner.nextInt();
	             i++;
	         }
	        }
        }
        finally {
        	if(scanner!=null)
        	scanner.close();
        	}
        heapSort(arr);
        for(int n:arr)
        {
        System.out.print(n+" ");
        }
}
}