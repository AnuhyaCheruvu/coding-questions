package thoughWorks;

import java.util.*;

/**
 * Created by anuhyacheruvu on 28/10/17.
 */
public class ChooseNumbers {
    private static int diff_result = 0;
    private static int k_result = 1;
    private static int s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            s = sc.nextInt();
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
            }


            for (int k = 2; k <= n; ++k) {
                getAllArrayCombinations(input, k);
            }
            System.out.println(k_result + " " + diff_result);
        }
    }

    private static int getMaxDifference(TreeSet<Integer> array) {
        int min = array.first();
        int max = array.last();

        return max - min;
    }

    private static void getAllArrayCombinations(int[] input, int k) {
        TreeSet<Integer> temp = new TreeSet<>();
        makeCombinations(temp, input, k, 0);

    }

    private static void makeCombinations(TreeSet<Integer> temp, int[] input, int k, int left) {
        if (k == 0) {
            updateResult(temp);
        }

        for (int i = left; i < input.length; i++) {
            temp.add(input[i]);
            makeCombinations( temp, input, k - 1, i + 1);
            temp.remove(input[i]);
        }

    }

    private static void updateResult(TreeSet<Integer> temp) {
        int k = temp.size();
        int diff = k * getMaxDifference(temp);
        if (k > k_result && diff <= s) {
            diff_result = diff;
            k_result = k;
        }
    }
}
