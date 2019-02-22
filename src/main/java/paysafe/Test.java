package paysafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anuhyacheruvu on 07/10/17.
 */
class Test {

    private static String[] pairs;
    private static int[] quantityGoods;

    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String goodsString;
        try {
            goodsString = br.readLine();
            int numGoods = Integer.parseInt(goodsString);
            String quantityGoodsString = br.readLine();
            String[] quantityGoodsStrings = quantityGoodsString.split(" ");
            quantityGoods = new int[numGoods];
            for (int i = 0; i < numGoods; i++) {
                quantityGoods[i] = Integer.parseInt(quantityGoodsStrings[i]);
            }
            String pairsString = br.readLine();
            String[] pairsStrings = pairsString.split(" ");
            int numPairs = Integer.parseInt(pairsStrings[0]);
            pairs = new String[numPairs];
            for (int i = 0; i < numPairs; i++) {
                String pairString = br.readLine();
                pairs[i] = pairString;
            }
            int numQueries = Integer.parseInt(br.readLine());
            int[] result = new int[numQueries];
            for (int i = 0; i < numQueries; i++) {
                int good = Integer.parseInt(br.readLine());
                result[i] = getLostMembers(good);
            }
            for (int i = 0; i < numQueries; i++) {
                System.out.print(result[i] + " ");
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int getLostMembers(int good) {
        updateQuantites(good);
        return checkLostMembers();
    }

    private static int checkLostMembers() {
        int count = 0;
        for (int k = 0; k < pairs.length; k++) {
            String[] pairStrings = pairs[k].split(" ");
            int start = Integer.parseInt(pairStrings[0]);
            int end = Integer.parseInt(pairStrings[1]);
            boolean lost = true;
            for (int i = start - 1; i <= end - 1; i++) {
                if (quantityGoods[i] != 0) {
                    lost = false;
                    break;
                }
            }
            if (lost) {
                count = count + 1;
            }
        }
        return count;
    }

    private static void updateQuantites(int good) {
        quantityGoods[good - 1] = quantityGoods[good - 1] - 1;
    }
}