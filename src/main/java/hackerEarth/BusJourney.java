package hackerEarth;

import java.util.Scanner;

/**
 * Created by anuhyacheruvu on 12/10/17.
 */
public class BusJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int number_standing = 0;
        int result = 0;
        int vacant_places = m;
        for (int i = 1; i <= n - 1; i++) {
            int entering = sc.nextInt();
            int leaving = sc.nextInt();
            vacant_places = vacant_places + leaving;
            if (number_standing != 0) {
                if(vacant_places != 0) {
                     if(number_standing > vacant_places) {
                         number_standing = number_standing-vacant_places;
                         vacant_places =0;

                     }
                     else {
                         vacant_places = vacant_places-number_standing;
                         number_standing = 0;
                     }
                }
            }
            if (vacant_places != 0) {
                if (entering > vacant_places) {
                    number_standing = entering - vacant_places;
                    vacant_places = 0;
                } else {
                    vacant_places = vacant_places - entering;
                }
            }
            else {
                number_standing = number_standing + entering;
            }
            if (vacant_places == 0) {
                result++;
            }

        }
        System.out.println(result);
    }
}
