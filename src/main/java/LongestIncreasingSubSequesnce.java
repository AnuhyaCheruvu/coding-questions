import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 19/09/17.
 */
public class LongestIncreasingSubSequesnce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        int result = getLIS(array, temp);
        System.out.print(result);
    }

    private static int getLIS(int[] array, int[] temp) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && temp[j] + 1 > temp[i]) {
                    temp[i] = temp[j] + 1;
                }
            }
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = max > temp[i] ? max : temp[i];
        }
        return max;
    }
}
