import java.util.Scanner;

import static java.lang.Integer.min;

/**
 * Created by anuhyacheruvu on 23/09/17.
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.next();
        String dst = sc.next();
        char[] x =src.toCharArray();

        int[][] dp = new int[src.length() + 1][dst.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < src.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dst.length() + 1; j++) {
            dp[0][j] = j;
        }

        int result = getNumberOfOperations(src, dst, dp);
        System.out.println(result);


    }

    private static int getNumberOfOperations(String src, String dst, int[][] dp) {
        for(int i =1;i <= src.length(); i++) {
            for(int j =1; j<=dst.length(); j++) {
                if(src.charAt(i-1) == dst.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int insert = 1+ dp[i-1][j-1];
                    int delete = 1+ dp[i-1][j];
                    int replace = 1+ dp[i][j-1];

                    dp[i][j] = min(insert, min(delete, replace));
                }
            }
        }

        return  dp[src.length()][dst.length()];

    }
}
