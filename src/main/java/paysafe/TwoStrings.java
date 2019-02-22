package paysafe;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 07/10/17.
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int q = sc.nextInt();
        sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            String result = checkSubString(s, t, start, end);
            System.out.println(result);
        }
    }

    private static String isSubString(String s, String t, int start, int end) {
        int j = 0;
        int i = 0;
        int m = t.length();
        int n = s.length();
        for (; i < n && j < m && m <= n; i++) {
            if (i == start - 1) {
                i = end - 1;
            } else if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        if (j == m) {
            return "Yes";
        }
        return "No";

    }

    private static String checkSubString(String s, String t, int start, int end) {
        StringBuilder t1 = new StringBuilder(t);
        int result =  getNumOfMatches(s,t1, 0, s.length()-1, start, end );
        if(result == t.length()) {
            return  "Yes";
        }
        else {
            return "No";
        }
    }

    private static int getNumOfMatches(String input, StringBuilder t, int left, int right, int start, int end) {
        if(left > right) {
            return 0;
        }
        if(left == right) {
            int i = t.indexOf(String.valueOf(input.charAt(left)));
            if(i != -1) {
                t.deleteCharAt(i);
                return 1 ;
            }
            return 0;
        }
        int mid = (left+ right)/2;
        int newLeft = mid+1;
        int newRight = mid;
        if (mid >= start-1 && mid<=end-1) {
            newRight = start-2;
            newLeft = end;
        }
        return getNumOfMatches(input,t,left,newRight,start,end) +
                getNumOfMatches(input, t, newLeft, right, start, end);
    }
}