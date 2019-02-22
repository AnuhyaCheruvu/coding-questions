package hackerEarth;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 02/10/17.
 */
public class Chocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxes = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for (int j = 1; j <= q; j++) {
            int num = sc.nextInt();
            int index = 0;
            if (num > 10) {
                index = num % 10 == 0 ? (num / 10) - 1 : num / 10;
            }
            int total = 0;
            for (int i = index; i<n; i++) {
                total = total + index*10 + boxes[i];
                if(num <= total) {
                    System.out.println(index+i + 1);
                    break;
                }

            }
        }

    }
}
