import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 24/09/17.
 */
public class StolenValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for(int i =0; i<n ; i++) {
            values[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = values[0];
        dp[1] = values[1];
        int maxValue = Integer.max(dp[0], dp[1]);
        maxValue = getMaxValue(values, dp, maxValue);
        System.out.println(maxValue);
    }

    private static int getMaxValue(int[] values, int[] dp, int maxValue) {
        for(int i = 0; i<values.length; i++) {
            int max = values[i];
            for(int j = i-2; j>=0; j--) {
                int currentMax = values[i] + dp[j];
                max = Integer.max(max, currentMax);
            }
            dp[i] = max;
            maxValue = Integer.max(max, maxValue);
        }

        return  maxValue;
    }
}
