package Oracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by anuhyacheruvu on 04/11/17.
 */
public class AraysSearch {
    static int[][] graph;
    private static HashMap<String, Integer> cityMap;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input_1 = reader.readLine();
        String[] cities =  input_1.split(" ");
        cityMap = new HashMap<>();
        int i =0;
        for(String city: cities) {
            cityMap.put(city,i);
            i++;
        }

        String input_2 = reader.readLine();
        String[] paths = input_2.split(" ");

        String input_3 = reader.readLine();
        String[] visit_cities = input_3.split(" ");

        graph = new int[cities.length][cities.length];
        prepareCityGraph(paths);

     //   for()



    }

    private static void prepareCityGraph(String[] paths) {
        for(String path: paths) {
            String[] cities = path.split("-");
            String start =cities[0];
            String end = cities[1];
            int start_index = cityMap.get(start);
            int end_index = cityMap.get(end);
            graph[start_index][end_index] = 1;
            graph[end_index][start_index] = 1;

        }
    }
}
