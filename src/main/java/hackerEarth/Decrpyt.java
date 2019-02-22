package hackerEarth;

import java.util.Scanner;


/**
 * Created by anuhyacheruvu on 02/10/17.
 */
public class Decrpyt {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String input = sc.next();
        String output = decode(input);
        System.out.println(output);
    }

    private static String decode(String input) {
        int length = input.length();
        StringBuffer temp = new StringBuffer(input);
        char[] output = new char[length];
        int i = length/2;
        int j = i - 1;
        while (temp.length()!= 0) {
            int n = temp.length();
            if(n%2!=0) {
                output[i] = temp.charAt(0);

                i++;
            }
            else {
                output[j] = temp.charAt(0);
                j--;

            }
            temp.deleteCharAt(0);
        }

        return String.valueOf(output);
    }
}
