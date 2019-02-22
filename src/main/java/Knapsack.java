import java.util.Scanner;

import static java.lang.Integer.max;

/**
 * Created by anuhyacheruvu on 23/09/17.
 */
public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[][] dp = new int[n+1][m+1];

        int maxValue = getMaxValue(weight, value, m , dp);
        System.out.println(maxValue);
    }

    private static int getMaxValue(int[] weight, int[] value, int m, int[][] dp) {
        int n = weight.length;
        for(int i = 1; i<=n; i++) {
            int w = weight[i - 1];
            for(int j = w; j<=m; j++) {
                int currentValue = value[i-1] + dp[i-1][j-w];
                dp[i][j] = max(currentValue, dp[i-1][j]);
            }
        }


        return dp[n][m];
    }
}
