package hackerEarth;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 08/11/17.
 */
public class FunnyArray {
    static HashMap<Integer,Integer>  map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        for(int i =0; i<n; i++) {
            input[i] = sc.nextInt();
            if(map.containsKey(input[i])) {
                int value = map.get(input[i]);
                value = value + i;
                map.put(input[i], value);
            }
            else {
                map.put(input[i], 1);
            }
        }
        final int[] max_length = {1};

        map.forEach((k, v)-> {
            if(v > max_length[0]) {
                max_length[0] = v;
            }
        } );
        System.out.println(max_length);
    }
}
