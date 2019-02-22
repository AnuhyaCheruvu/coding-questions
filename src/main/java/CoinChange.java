import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 16/09/17.
 */


public class CoinChange {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCoins = sc.nextInt();
        int n = sc.nextInt();

        int[][] array = new int[numberOfCoins+1][n+1];


        for(int i =0; i<=numberOfCoins; i++) {
            for(int j =0; j<=n; j++) {
                array[i][j] = -1;
            }
        }
        array[1][1] = 1;

        int result = getNumberOfCoins(numberOfCoins, n, array);
        System.out.println(result);


    }

    private static int getNumberOfCoins(int numberOfCoins, int n, int[][] array) {

        if (numberOfCoins == 1) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if(array[numberOfCoins][n] != -1) {
            return array[numberOfCoins][n];
        }


        int result = getNumberOfCoins(numberOfCoins - 1, n, array) + getNumberOfCoins(numberOfCoins, n - numberOfCoins, array);
        array[numberOfCoins][n] = result;
        return result;
    }
}
