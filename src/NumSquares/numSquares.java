package NumSquares;

public class numSquares {
	public static int numS(int n) {
	     //DP bottom up: for each number till n
        //TODO: edge cases
        //initialize C
        int[] C = new int[n+1];
        for(int k = 1; k <= n; k++){
            C[k] = k;
        }
        
        //update C
        for(int i = 1; i <= n; i ++){
            int sqrt = (int) Math.sqrt(i);
            if(sqrt*sqrt == i){ //is a sqrt itself  ///TODO: In fact, can be included in the inner loop: as long as C[0] = 0
                C[i] = 1;                           ///TODO: Could put it outside outer loop: return 1 immediately
            }else{
                for(int j =1; j<=sqrt; j++){ //go from 1 to sqrt
                    int remain = i-j*j;
                    if(1 + C[remain] < C[i]){ //TODO:Or can do a choose Math.min
                        C[i] = C[remain] + 1;
                    }
                }
            }
        }
        
        return C[n];
	}
	
	public static void main(String[] args) {
	    System.out.println("input 1: " + numS(1));
        System.out.println("input 5: " + numS(5)); // 2
        System.out.println("input 10: " + numS(10)); // 10 = 9 +1 = 2
		System.out.println("input 12: " + numS(12)); //3: 12 = 4 + 4 +4
	    System.out.println("input 13: " + numS(13)); //2: 4 + 9
	}
}
