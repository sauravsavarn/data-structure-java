package org.datastructure.java.recurrsion.printSubsetsOfArray;

public class Solution {
    public static void printSubsets(int input[]) {
        // Write your code here
        String[] subsets = subsets(input);
        for (String subset: subsets) {
            System.out.println(subset);
        }
    }

    private static String[] subsets(int num[]) {
        ////base case
        if (num.length==0) {
            String output[] = new String[1];
            output[0] = "";
            return output;
        }
        ////otherwise
        int[] smallerArr = new int[num.length-1];
        System.arraycopy(num, 1, smallerArr,0, num.length-1);
        String[] smallerOutput = subsets(smallerArr);

        String[] output = new String[smallerOutput.length * 2];

        for (int i = 0; i < smallerOutput.length; i++) {
            output[i] = smallerOutput[i];
        }
        for (int i = 0; i < smallerOutput.length; i++) {
            output[smallerOutput.length + i] = num[0] + " " + smallerOutput[i];
        }

        return output;
    }
}
