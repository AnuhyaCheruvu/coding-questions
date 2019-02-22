package hackerEarth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 01/10/17.
 */
public class StampTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            long k = sc.nextLong();
            BigInteger area = getMaxArea(m, n, k);
            System.out.println(area);
        }
    }

    private static BigInteger getMaxArea(int m, int n, long k) {
        BigInteger area = BigInteger.ZERO;
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >=1; j--) {
                BigInteger temp = BigInteger.valueOf(i);
                temp = temp.multiply(BigInteger.valueOf(j));
                if (temp.longValue() <= k) {
                    return temp;
                }

            }
        }
        return area;
    }
}
