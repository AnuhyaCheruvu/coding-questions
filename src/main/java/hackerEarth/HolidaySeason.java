package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 10/10/17.
 */
public class HolidaySeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        char[] array = input.toCharArray();
        int[] count = new int[26];
        int result = 0;

        for(int b = 0; b<n; b++) {
            for(int d = b+1; d<n; d++) {
                if(array[b] == array[d]) {
                    for(int c = b+1; c<d;c++) {
                        result = result+ count[array[c]-'a'];
                    }
                }
            }
            count[array[b]-'a'] ++;


        }
        System.out.println(result);


    }
}
