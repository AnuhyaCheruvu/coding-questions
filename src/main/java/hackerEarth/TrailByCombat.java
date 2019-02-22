package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 28/09/17.
 */
public class TrailByCombat {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[] a = new int[n];
            for (int k = 0; k < n; k++) {
                a[k] = s.nextInt();
            }
            int count = 0;

            for (int j = 1; j <= m; j++) {
                int temp = a[0];
                if (a[1] == 1) {
                    a[0] = 1;
                } else {
                    a[0] = 0;
                }

                int i;
                for (i = 1; i < n - 1; i++) {

                    if (temp == 1 && a[i + 1] == 1) {
                        temp = a[i];
                        a[i] = 1;
                    } else {
                        count ++;
                        temp = a[i];
                        a[i] = 0;
                    }


                }
                if (a[i - 1] == 1) {
                    a[i] = 1;
                } else {
                    a[i] = 0;
                }

            }

            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

    }
}
