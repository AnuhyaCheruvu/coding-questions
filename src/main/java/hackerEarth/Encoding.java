package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 04/03/18.
 */
public class Encoding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String result = collapsedString(input);

        System.out.println(result);

    }

    private static String collapsedString(String input) {
        int length = input.length();
        StringBuilder output = new StringBuilder();
        char start = input.charAt(0);
        int count = 1;

        for(int i =1; i<length; i++) {
            char c = input.charAt(i);
            if(c == start) {
                count ++;
            }
            else{
                output.append(count);
                output.append(start);
                count = 1;
                start = c;
            }
        }
        output.append(count);
        output.append(start);

        return output.toString();
    }


}
