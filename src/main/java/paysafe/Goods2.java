package paysafe;

import java.util.*;

/**
 * Created by anuhyacheruvu on 08/10/17.
 */
public class Goods2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Set<Integer> settled = new HashSet<Integer>(m);
        sc.nextInt();
        List<Set> list = new ArrayList<Set>(m);
        for(int i =1; i<=m ; i++) {
            Set<Integer> stocks = new HashSet<Integer>();
            int l = sc.nextInt();
            int r = sc.nextInt();
            for (int j = l; j <= r; j++) {
                stocks.add(j-1);
            }
            list.add(stocks);
        }
        int count = 0;
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int num = sc.nextInt();
            if(goods[num-1]!= 0) {
                goods[num-1] --;
                if(goods[num-1] ==0 && count<=m) {
                    int index =0;
                    for(Set item: list) {
                        if(!settled.contains(i) && item.contains(num-1)) {
                            if(item.size()==1) {
                                item.remove(num-1);
                                count++;
                                settled.add(i);

                            }
                            else {
                                item.remove(num-1);
                            }
                        }
                        index++;
                    }

                }

            }
            System.out.print(count + " ");
        }
    }
}
