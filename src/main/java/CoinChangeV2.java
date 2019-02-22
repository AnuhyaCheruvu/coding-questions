import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 16/09/17.
 */
public class CoinChangeV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
        int numberOfCoins = sc.nextInt();
         int[] coins = new int[numberOfCoins];
         long[][]array = new long[numberOfCoins+1][n+1];
         int i =0;
         for(; i<numberOfCoins; i++) {
             coins[i] = sc.nextInt();
             Arrays.fill(array[i], -1);
         }
         Arrays.fill(array[i], -1);
         long result = getNumberOfCoins(numberOfCoins, n , array, coins);
        System.out.println(result);
    }

    private static long getNumberOfCoins(int numberOfCoins, int n, long[][] array, int[] coins) {

        if (n <  0 || numberOfCoins==0 ) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        if(array[numberOfCoins][n] != -1) {
            return array[numberOfCoins][n];
        }
        long result = getNumberOfCoins(numberOfCoins - 1, n, array, coins) +
                getNumberOfCoins(numberOfCoins, n - coins[numberOfCoins-1], array, coins);
        array[numberOfCoins][n] = result;
        return result;

    }
}
