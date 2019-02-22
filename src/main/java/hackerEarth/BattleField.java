package hackerEarth;

/**
 * Created by anuhyacheruvu on 03/02/18.
 */

import java.util.*;

class BattleField {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            List<Integer> k = new ArrayList<>();
            String input = sc.next();
            char[] input_array = input.toCharArray();
            for(int i =0; i<n ; i++) {
                //System.out.println(input_array[i]);
                if(input_array[i] == 'K') {
                    //System.out.println("true");
                    k.add(i);
                }
            }


            int swaps = getSwaps(k, n, input_array) ;
            System.out.println(swaps);

        }

    }

    public static int getSwaps(List<Integer> k, int n, char[] input_array) {
        int swaps = n;
        int number_k = k.size();
        for(Integer index: k) {
            int x = 0;
            for(int i = index + 1 , j = 0; j < number_k-1; i++, j++)  {
                if(i> n-1) {
                    i = i - n;
                }
                if(input_array[i] == 'D') {
                    x ++;
                }

            }
            swaps = swaps < x ? swaps : x;

            if(swaps == 0 || swaps == 1) {
                break;
            }

        }

        return swaps;

    }
}
