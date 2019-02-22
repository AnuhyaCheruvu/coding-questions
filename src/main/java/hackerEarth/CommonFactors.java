package hackerEarth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 28/09/17.
 */
public class CommonFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        int commonFactors = getCommomFactors(a, b);
        System.out.println(commonFactors);
    }

    private static int getCommomFactors(long a, long b) {
        int commonFactors = 0;
        long gcd = getGCD(a,b);
        for(int i =1; i<=Math.sqrt(gcd); i++) {
            if(gcd%i==0){
                if(gcd/i ==i) {
                    commonFactors++;
                }
                else {
                    commonFactors = commonFactors+2;
                }
            }
        }
        return commonFactors;
    }

    private static long getGCD(long a, long b) {
        if(a==0) {
            return b;
        }
        else {
            return getGCD(b%a,a);
        }
    }


}
