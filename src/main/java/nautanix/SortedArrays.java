package nautanix;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 12/11/17.
 */
public class SortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] inputAsc = new int[n];
        int[] inputDsc = new int[n];
        for(int i =0; i<n; i++) {
            input[i] = sc.nextInt();
            inputAsc[i] = input[i];
            inputDsc[i] = input[i];
        }
        int result;
        int resultAsc = getMinMovesAsc(inputAsc);
        int  resultDsc = getMinMovesDsc(inputDsc);
        result = Integer.min(resultAsc,resultDsc);
        System.out.print(result);
    }

    private static int getMinMovesDsc(int[] input) {
        int n = input.length;
        int moves  = 0;
        for(int i = n-1; i >0 ; i--) {
            if(input[i] < input[i-1]) {
                continue;
            }
            else {
                int temp= input[i] -input[i-1];
                moves = moves + temp +1;
                input[i] = input[i] + moves;
            }
        }
        return moves;

    }

    private static int getMinMovesAsc(int[] input) {
        int n = input.length;
        int moves  = 0;
        for(int i =1; i<n ; i++) {
            if(input[i] > input[i-1]) {
                continue;
            }
            else {
                int temp= input[i-1] -input[i];
                moves = moves + temp +1;
                input[i] = input[i] + moves;
            }
        }
        return moves;

    }
}
