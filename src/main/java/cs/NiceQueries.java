package cs;

import java.util.*;

/**
 * Created by anuhyacheruvu on 19/11/17.
 */
public class NiceQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        Set<Integer> set = new TreeSet<>();
        int q = sc.nextInt();

        while (q > 0) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();

            if (temp1 == 1) {
                input[temp2 - 1] = -1;
                set.add(temp2);
            } else {
                int result = -1;
                if (set.size() == n) {
                    result = temp2;
                } else {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()) {
                        int value = it.next();
                        if (value >= temp2) {
                            result = temp2;
                            break;
                        }
                    }
                }
                System.out.println(result);
            }
            q--;

        }
    }
}
