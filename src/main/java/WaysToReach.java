import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 19/09/17.
 */
public class WaysToReach {
    private static int[] scores = {3, 5, 10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int result = getMoves(score);
        System.out.println(result);
    }

    private static int getMoves(int score) {
        int[] result = new int[score + 1];
        result[0] = 1;
        int i;


        for(i=3;i<=score;i++)
            result[i]+=result[i-3];

        //Now, count the ways using move 5
        for(i=5;i<=score;i++)
            result[i]+=result[i-5];

        //now, the final result will be calculated
        for(i=10;i<=score;i++)
            result[i]+=result[i-10];
        return result[score];
    }


}
