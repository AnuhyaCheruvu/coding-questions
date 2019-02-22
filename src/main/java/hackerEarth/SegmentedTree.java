package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 04/02/18.
 */
public class SegmentedTree {

    public static class Query {
        int start;
        int end;
        int value;

        public Query(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Query[] queries = new Query[q];
        int[] input = new int[n];
        int start = 1;
        int end = 1;
        int max = 0;


        for (int i = 1; i <= q; i++) {
            int start_index = sc.nextInt();
            int end_index = sc.nextInt();
            int value = sc.nextInt();

            for (int j = start_index - 1; j < end_index; j++) {
                input[j] += value;
                if (max < input[j]) {
                    start = j + 1;
                    end = j + 1;
                    max = input[j];
                }
                if (max == input[j]) {
                    end = j + 1;
                }
            }
            queries[i - 1] = new Query(start_index, end_index, value);
        }

        int result = getMinValue(queries, q, n, start, end, max, input);
        System.out.println(result);


    }

    private static int getMinValue(Query[] queries, int q, int n, int start, int end, int value, int[] input) {
        int min = value;

        for (int i = 1; i <= q; i++) {
            Query query = queries[i - 1];
            int start_index = query.start;
            int end_index = query.end;

            int max = value - query.value;
            if (!doesIndicesOverlap(start, end, start_index, end_index)) {
                max = value - query.value;


                //int j = start_index < start ? start_index : start;
                //int k = end > end_index ? end : end_index;
                for (int j = start_index - 1; j < end_index; j++) {
                    if (input[j] > max) {
                        max = input[j];
                    }
                }
                min = min < max ? min : max;

            }

        }
        return min;

    }

    private static boolean doesIndicesOverlap(int start, int end, int start1, int end1) {
        if ((start <= start1 && start1 <= end) || (start <= end1)) {

            return true;
        }

        return false;
    }
}
