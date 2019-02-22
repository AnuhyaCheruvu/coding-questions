package hackerEarth;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anuhyacheruvu on 04/03/18.
 */
public class ParanthesisMatcher {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int position = Integer.parseInt(bufferedReader.readLine());

        int result = closingBracePosition(input, position);

        System.out.println(result);

    }

    private static int closingBracePosition(String inputSentence, int openingBraceNum) {
        int length = inputSentence.length();
        Stack<Character> stack = new Stack<>();
        int result = -1;
        int num =0;
        boolean notSolved = false;
        for (int i = 0; i < length; i++) {
            char c = inputSentence.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                num ++;
            }

            if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    if (isMatchingPair(stack.pop(), c)) {
                        if (openingBraceNum == num && !notSolved) {
                            result = i + 1;
                            notSolved = true;
                        }
                        num --;
                    } else {
                        return -1;
                    }
                }

            }


        }

        if (!stack.isEmpty()) {
            return -1;
        }


        return result;
    }

    private static boolean  isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }
}



