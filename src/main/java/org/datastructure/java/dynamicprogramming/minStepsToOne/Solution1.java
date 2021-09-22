package org.datastructure.java.dynamicprogramming.minStepsToOne;

public class Solution1 {

    public static int countMinStepsToOne(int n) {
        //Your code goes here
        if(n==1) return 0;
        else if(n==2) return 1;
        int output = countMinStepsTo1(n, 0);

        return output;
    }

    private static int countMinStepsTo1(int n, int count) {
        if(n==1)return count;
        if(n%3!=0 && n%2!=0)
            n=n-1;
        else if(n%2==0) {
            if( (n-1)%3==0 ) n = n-1;
            else n=n/2;
        }
        else if(n%3==0) n=n/3;

        int output = countMinStepsTo1(n, count+1);
        return output;
    }
}
