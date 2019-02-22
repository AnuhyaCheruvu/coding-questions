package hackerEarth;


import java.util.Scanner;
/**
 * Created by anuhyacheruvu on 28/09/17.
 */
public class ArrayUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++) {
            int num = sc.nextInt();
            array[i] = num;
            sum = sum+num;
        }
        int result = (sum/n) +1;
        System.out.println(result);
    }
}
