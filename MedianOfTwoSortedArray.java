public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
		if (A == null || B == null)
			return 0;
		int m = A.length, n = B.length, mid = (m + n) / 2;
		boolean even = ((m + n) & 1) == 0;
		System.out.println((m + n) & 11);

		int left = Math.max(0, mid - n), right = Math.min(m - 1, mid);
		while (left <= right) {
			int i = (left + right) / 2, j = mid - 1 - i;
			if (j >= 0 && A[i] < B[j])
				left = i + 1;
			else if (j < n - 1 && A[i] > B[j + 1])
				right = i - 1;
			else {
				if (!even)
					return A[i];
				else if (j < 0 || j >= n)
					return (A[i] + A[i - 1]) / 2.0;
				else if (i <= 0)
					return (A[i] + B[j]) / 2.0;
				else
					return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
			}
		}
		return findMedianSortedArrays(B, A);
	}
	public static void main(String args[])
    {
            int[] a= {1,2,3,4};
            int[] b= {3,4,5};
            double res =findMedianSortedArrays(a,b);
            System.out.println(res);
            
    }

}