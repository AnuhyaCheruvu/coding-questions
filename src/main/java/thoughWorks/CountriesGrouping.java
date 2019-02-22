package thoughWorks;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 28/10/17.
 */
public class CountriesGrouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
            }
            int result = getNumberOfCountries(input);
            if (result == -1) {
                System.out.println("Invalid Data");
            } else {
                System.out.println(result);

            }
        }
    }

    private static int getNumberOfCountries(int[] input) {
        int n = input.length;
        int i = 0;
        int numberOfCountries = 0;
        boolean isValid = true;
        while (i < n) {
            int number = input[i];
            if (number > n - i) {
                return -1;
            }
            int k = i + 1;
            while (k <= i + number - 1 && k < n) {
                if (input[k] == number) {
                    k++;
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                numberOfCountries++;
            } else {
                return -1;
            }
            i = k;
        }
        return numberOfCountries;
    }
}
