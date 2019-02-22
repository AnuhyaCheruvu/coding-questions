package hackerEarth;

/**
 * Created by anuhyacheruvu on 02/10/17.
 */
public class Test {
    public static void main(String[] args) {
        /*String X[] = {"m", "n", "p", "m", "p"};
        for (int i = 0; i < X.length; ++i)
            for (int j = i + 1; j < X.length; ++j)
                if(X[i].compareTo(X[j]) == 0)
                    System.out.print(X[j]);*/
        /*String a1 = "Stop";
        StringBuffer ab = new StringBuffer(a1);

        ab.reverse();
        a1.concat(ab.toString());

        System.out.println(a1 + ab + a1.length() + ab.length());*/

        byte a = 4;
        byte b = 6;
        System.out.print((b%a) + ", ");
        System.out.println(b == ( (b/a)*a + (b%a) ));
    }

}
