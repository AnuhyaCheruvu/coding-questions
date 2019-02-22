import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 16/09/17.
 */
public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count;
            count = cutRod(n);
            System.out.println(count);
        }
    }

    private static int cutRod(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return cutRod(n / 2);
        } else {

            return 1 + cutRod(n / 2);
        }
    }
}
