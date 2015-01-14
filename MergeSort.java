import java.util.Scanner;
public class MergeSort
{

public static void mergeSort(int a[],int lo,int hi)
{
		int mid;
		if(lo < hi)
		{
		mid=(lo+hi)/2;
		mergeSort(a,lo,mid);
		mergeSort(a,mid+1,hi);
		merge(a,lo,mid,hi);
		}
}
		
public static void merge(int a[],int lo,int mid,int hi)
{
		int i,j,k;
		int n1= mid-lo+1;	
		int n2 = hi-mid;
		int L[]=new int[n1];
		int R[]=new int[n2];
		for(i=0;i<n1;i++) L[i]=a[lo+i];
		for(j=0;j<n2;j++) R[j]=a[mid+1+j];
		i = j = 0;
		k = lo;
		while(i<n1 && j<n2)
		{
			if(L[i]<=R[j])
			{
			 a[k] = L[i];
			 i++;
			}
			else
			{
			a[k]=R[j];
			j++;
			}
		k++;
		}
		while (i < n1)
		    {
        		a[k] = L[i];
        		i++;
        		k++;
    		}
 		while (j < n2)
		    {
        		a[k] = R[j];
        		j++;
        		k++;
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
	   int len = arr.length;
        mergeSort(arr,0,len-1);
        for(int n:arr)
        {
        System.out.print(n+" ");
        }
}
}
		