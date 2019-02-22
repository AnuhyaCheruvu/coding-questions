package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 01/10/17.
 */
public class BestSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            long sum = getMaxOddSum(array);
            System.out.println(sum);
        }
    }

    private static long getMaxOddSum(long[] array) {
        int n = array.length;
        long sum = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (array[i] > 0) {
                sum = sum + array[i];
            }
            if (isOdd(array[i])) {
                min = min > Math.abs(array[i]) ? Math.abs(array[i]) : min;
            }
        }
        if(isOdd(sum)) {
            return sum;
        }
        else return sum-min;

    }

    private static boolean isOdd(long sum) {
        return !(sum % 2L == 0);
    }
}
