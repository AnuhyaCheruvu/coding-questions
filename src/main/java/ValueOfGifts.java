import java.util.Scanner;


/**
 * Created by anuhyacheruvu on 23/09/17.
 */
public class ValueOfGifts {

    private static int m;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] input = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = input[m-1][n-1];
        int maxValue = getMaxValue(input, dp, 0, 0);
        System.out.println(maxValue);

    }

    private static int getMaxValue(int[][] input, int[][] dp, int row, int col) {
        if(row >= m || col>=n ) {
            return 0;
        }
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        else {
            int max_right = getMaxValue(input, dp, row, col+1);
            int max_bottom = getMaxValue(input, dp, row+1, col );

            return input[row][col] + Integer.max(max_bottom, max_right);
        }

    }
}
