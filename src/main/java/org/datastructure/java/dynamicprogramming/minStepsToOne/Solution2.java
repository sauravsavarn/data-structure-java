package org.datastructure.java.dynamicprogramming.minStepsToOne;

public class Solution2 {

    public static int countMinStepsToOne(int n) {
        //Your code goes here
        if(n==1) return 0;
        else if(n==2) return 1;
        int output = countMinStepsTo1(n);

        return output;
    }

    private static int countMinStepsTo1(int n) {

        if(n==1)return 0;

        int ans1 = countMinStepsTo1(n-1);

        int ans2 = Integer.MAX_VALUE;
        if(n%2==0) ans2 = countMinStepsTo1(n/2);

        int ans3 = Integer.MAX_VALUE;
        if(n%3==0) ans3 = countMinStepsTo1(n/3);

        int output = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        return output;
    }
}
