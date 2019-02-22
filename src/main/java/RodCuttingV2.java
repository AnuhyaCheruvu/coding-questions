import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 17/09/17.
 */
public class RodCuttingV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        int[] max_cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int rodSize = sc.nextInt();
        int j = cost[0];
        max_cost[0] = j;
        int result = maxCost(rodSize, cost, max_cost);

        System.out.println(result);
    }

    private static int maxCost(int rodSize, int[] cost, int[] max_cost) {
        if (max_cost[rodSize - 1] != 0) {
            return max_cost[rodSize - 1];
        }
        int max = cost[rodSize - 1];
        for (int i = 1; i <= rodSize / 2; i++) {
            int temp = maxCost(i, cost, max_cost) + maxCost(rodSize - i, cost, max_cost);
            max = max > temp ? max : temp;

        }
        max_cost[rodSize - 1] = max;
        return max;
    }
}
