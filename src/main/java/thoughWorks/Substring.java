package thoughWorks;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 10/12/17.
 */
public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        long length = input.length();
        long n = sc.nextLong();

        for (long i = 1; i <= n; i++) {
            long num = sc.nextLong();
            long start = (num - 1l) / length;
            long end = (num - 1) % length + 1 + start;
            if (end > length) {
                start = start + (end - length);
                end = length;
            }
            if (start >= length) {
                System.out.println(-1);
            } else {

                System.out.println(input.substring((int)start, (int)end));
            }


        }
    }
}
