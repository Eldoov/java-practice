public class polynomialAddition {
//Polynomial 3-3x+ 5x**2+x**3 + 1-2x**2+4x**5 
		public static int max(int m, int n){
			return (m > n)? m: n;
		}

		// A[] is first polynomial 
		// B[] is second polynomial 
	public static int[] add(int[] A, int[] B, int m, int n){
		int size = max(m, n);
		int[] sum = new int[size];

		for (int i = 0; i < m; i++){
			  sum[i] = A[i];
		}

		for (int i = 0; i < n; i++){
			  sum[i] += B[i];
		}

		return sum;
	}

		// print polynomial 
	public static void printPoly(int[] poly, int n){
		for (int i = 0; i < n; i++){
			System.out.print(poly[i]);
			if (i != 0){
				  System.out.print("x^");
				  System.out.print(i);
		  }
		  if (i != n - 1){
			 System.out.print(" + ");
		}
	}
}

		// Driver program to test above functions
	public static void main(String[] args){
		int[] A = {3, -3, 5, 1};
		int[] B = {1, 0, -2, 0, 0, 4};
		int m = A.length;
		int n = B.length;

		System.out.print("First input is: \n");
		printPoly(A, m);
		System.out.print("\n\nSecond input is: \n");
		printPoly(B, n);

		int[] sum = add(A, B, m, n);
		int size = max(m, n);

		System.out.print("\n\nThe sum is: \n");
		printPoly(sum, size);

	}
}
