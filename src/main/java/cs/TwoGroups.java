package cs;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 19/11/17.
 */
public class TwoGroups
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n =  sc.nextInt();
            BigInteger two = new BigInteger("2");
            BigInteger temp1 = two.pow(n);
            temp1 = temp1.subtract(two);
            BigInteger result = temp1.mod(new BigInteger("1000000007"));
            System.out.println(result.floatValue());

            t--;
        }
    }
}
