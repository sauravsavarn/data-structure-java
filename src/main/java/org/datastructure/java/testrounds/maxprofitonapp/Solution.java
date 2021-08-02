package org.datastructure.java.testrounds.maxprofitonapp;

import java.util.Arrays;

public class Solution {
    static int num=0;
    static int priceOfApp = 20;
    static int profit = 0;
    public static int maximumProfit(int budget[]) {
        num = budget.length;
        ///
        Arrays.sort(budget);


        for (int perPersonBudget: budget) {

            if(profit < perPersonBudget*num)
                profit = perPersonBudget*num;

            num = num -1;
//            if(perPersonBudget > priceOfApp)
//                profit = profit + (perPersonBudget - priceOfApp);
        }

        return profit;
    }
}
