import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 24/09/17.
 */
public class StolenValuesV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for(int i =0; i<n; i++) {
            values[i] = sc.nextInt();
        }
        int max = getMax(values);
        System.out.println(max);
    }

    private static int getMax(int[] values) {
        int n = values.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] =values[0];
        for(int i =2; i<=n ; i++) {
            dp[i] = Integer.max(dp[i-1], values[i-1] + dp[i-2]);
        }

        return dp[n];
    }

}
