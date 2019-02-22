import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 09/09/17.
 */
public class HalloweenSale {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);
        in.close();
    }

    private static int howManyGames(int p, int d, int m, int s) {
        int count = 0;
        int sum = p;
        int previousCost = p;

        while(sum <= s) {
            int i = previousCost - d;
            int currentCost = i <=m ? m : i;
            previousCost = currentCost;
            sum = sum + currentCost;
            count ++;
        }
        return count;

    }
}
