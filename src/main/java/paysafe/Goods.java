package paysafe;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 07/10/17.
 */
public class Goods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        sc.nextInt();
        int[][] result = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            for (int j = l; j <= r; j++) {
                result[i][j - 1] = 1;
                result[i][n]++;
            }
        }
        int count = 0;
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int num = sc.nextInt();
            if (goods[num - 1] != 0) {
                goods[num - 1]--;
                for (int j = 0; j < m && count <=m; j++) {
                    if (result[j][num - 1] != 0 && result[j][n] != 0) {
                        if (goods[num - 1] == 0) {
                            result[j][n]--;
                        }
                        if (result[j][n] == 0) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
