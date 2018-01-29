package Recursion;

public class Problem2 {
	public static int RecursionTerm(int n) {
		int[] r = new int[n+1];
		r[0] = 0;
		int q = 0;
		for(int j=1; j<=n; j++) {
			q = r[j-1]*2+1;
			r[j] = q;
			System.out.println(q);
		}
		return r[n];
	}
	
	public static void main(String arg[]) {
		int n = 50;
		int r = RecursionTerm(n);
		System.out.println("returned an: " + r);
		int k = (2*r);
		System.out.println("final sum: " + (r%n));
	}
}
