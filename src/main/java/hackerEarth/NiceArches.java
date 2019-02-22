package hackerEarth;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anuhyacheruvu on 04/10/17.
 */
public class NiceArches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int count = 0;
        for (int i =1; i<=m; i++) {
            String input = sc.next();
            Stack<Character> stack= new Stack<Character>();
            for(int j =0; i<input.length(); j++) {
                if (stack.peek() == input.charAt(j)) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
