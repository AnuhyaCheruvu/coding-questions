package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 03/10/17.
 */
public class AlmondProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int K = sc.nextInt();

            int days =  solve(A, B, K);
            System.out.println(days);
        }
    }

    private static int solve(int a, int b, int k) {
        int i = k - a;
        if(i >= 0) {
            int temp = i+b;
            if(temp% a == 0) {
                return -1;
            }
            return 1+ temp/a;
        }
        return 0;
    }
}
