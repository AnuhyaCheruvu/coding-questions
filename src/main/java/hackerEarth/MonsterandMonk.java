package hackerEarth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 02/10/17.
 */
public class MonsterandMonk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String q = sc.next();
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] dp = new int[n + q.length()];
        /*fo
        r(int i = 0; i <q.length()-1 ; i++) {
            dp[p.length()-i-1] = array[p.length()-i-1];
        }*/
        int cost = getCost(p, q, array, 0, dp);
        System.out.println(cost);

    }

    private static int getCost(String p, String q, int[] array, int previousIndex, int[] dp) {
        for (int i = p.length() - q.length(); i >= 0; i--) {
            int index = p.indexOf(q, i);
            if (index == previousIndex) {
                dp[i] = dp[index];
            } else if (index != -1) {
                int currentMax = array[i] + dp[index + q.length()];
                dp[i] = Integer.max(currentMax, dp[i + 1]);
                previousIndex = index;
            }
        }
        return dp[0];
    }
}


