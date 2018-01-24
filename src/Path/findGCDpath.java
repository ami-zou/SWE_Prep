package Path;

import java.math.BigInteger;

public class findGCDpath {
    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        int size = destinationCities.length;
        int[] answers = new int[size];
        for(int i = 0; i < size; i++) {
        		int ori = originCities[i];
        		int des = originCities[i];
        		int p = hasPath(ori, des, n);
        		answers[i] = p;
        }
        return answers;

    }
    
    static int hasPath(int ori, int des, int n) {
    		int hasPath = 0;
    		return hasPath;
    }
    
    static boolean satisfiesGCD(int x, int y, int g){
        BigInteger b1 = BigInteger.valueOf(x);
        BigInteger b2 = BigInteger.valueOf(y);
        BigInteger gcd = b1.gcd(b2);
        return g > gcd.intValue(); 
     }
}
