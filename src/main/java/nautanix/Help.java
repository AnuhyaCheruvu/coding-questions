package nautanix;

import java.util.*;

/**
 * Created by anuhyacheruvu on 12/11/17.
 */
public class Help {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> petrol_units = new PriorityQueue<>(n, Collections.reverseOrder());
        HashMap<Long, Long> distances = new HashMap<>(n);

        for(int i = 0; i<n ; i++) {
            long distance = sc.nextInt();
            long petrol = sc.nextInt();
            petrol_units.add(petrol);
            distances.put(petrol, distance);

        }
        long distance = sc.nextInt();
        long petrol = sc.nextInt();

        int result = 0;

        while(distance > petrol && distance >0) {
            if(petrol_units.isEmpty()) {
                result = -1;
                break;
            }
            else {
                long curr_max = petrol_units.poll();
                long distance_rem = distances.get(curr_max);

                if(distance_rem > distance || (distance-distance_rem) > petrol) {
                    distances.remove(curr_max);
                    continue;
                }
                else {
                    petrol = petrol - (distance - distance_rem) + curr_max;
                    distance = distance_rem;
                    distances.remove(curr_max);
                    result++;

                }

            }
        }

        System.out.println(result);

    }
}
