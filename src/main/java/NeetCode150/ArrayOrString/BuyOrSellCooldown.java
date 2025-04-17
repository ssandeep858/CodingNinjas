/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.HashMap;
import java.util.List;
//import javafx.util.Pair;

/**
 *
 * @author ssingh
 */
public class BuyOrSellCooldown {

    public static int maxProfit(int[] prices, int index, int buyOrSell) {
        if (index >= prices.length) {
            return 0;
        }
        int maxProfit = 0;
        if (buyOrSell == 0) {
            // buy krunga ya cool
            int buy = maxProfit(prices, index + 1, 1) - prices[index];
            int cool = maxProfit(prices, index + 1, 0);
            maxProfit = Math.max(buy, cool);

        } else {
            int sell = maxProfit(prices, index + 2, 0) + prices[index];
            int cool = maxProfit(prices, index + 1, 1);
            maxProfit = Math.max(cool, sell);
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        // state=> buying/selling
        // buying=> i+1
        //selling => i+2 as cooldown is 1 day
        return maxProfit(prices, 0, 0);
    }

    public static int maxProfitMemoization(int[] prices, int index, int buyOrSell, HashMap<String,Integer> hm) {
        if (index >= prices.length) {
            return 0;
        }
        String key=index+" "+buyOrSell;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        int maxProfit = 0;
        if (buyOrSell == 0) {
            // buy krunga ya cool
            int buy = maxProfitMemoization(prices, index + 1, 1,hm) - prices[index];
            int cool = maxProfitMemoization(prices, index + 1, 0,hm);
            maxProfit = Math.max(buy, cool);

        } else {
            int sell = maxProfitMemoization(prices, index + 2, 0,hm) + prices[index];
            int cool = maxProfitMemoization(prices, index + 1, 1,hm);
            maxProfit = Math.max(cool, sell);
        }
        hm.put(key, maxProfit);
        return maxProfit;
    }

    public static int maxProfitMemoization(int[] prices) {
        // state=> buying/selling
        // buying=> i+1
        //selling => i+2 as cooldown is 1 day
        HashMap<String,Integer> hm=new HashMap<>();
        return maxProfitMemoization(prices, 0, 0,hm);
    }

    public static void main(String[] args) {
        System.out.println(maxProfitMemoization(new int[]{1, 2, 3, 0, 2}));
    }

}
