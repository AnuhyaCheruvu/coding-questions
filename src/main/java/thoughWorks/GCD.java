package thoughWorks;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 10/12/17.
 */
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>=0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i< n; i++) {
                a[i] = sc.nextInt();
            }

            int result = 0;
            for(int i =0; i<n-1; i++) {
                for(int j = i+1; j<n; j++) {
                    int gcd = gcd(a[i], a[j]);
                    if(gcd !=k) {
                        int temp = gcd(a[i], a[i]);
                    }
                }
            }
            t--;
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}
