package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 05/10/17.
 */
public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int max = getMax(array, n);
            System.out.println(max);
        }

    }

    private static int getMax(int[] array, int n) {
        int max = array[0];
        int min = array[0];
        int max_i = 0;
        int max_j = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
                max_i = i;
            }
            else if(array[i] <min) {
                min = array[i];
                max_j =i;
            }
        }
        return Math.abs(max-min) + Math.abs(max_i-max_j);

    }
}
