package org.datastructure.java.dynamicprogramming.minCostPathProblem;

////Recursive way of Implementation
public class Solution1 {

    public static int minCostPath(int[][] input) {
        //Your code goes here
        int minCostPath = minCost(input, 0, 0, input.length, input[0].length);
        return minCostPath;
    }

    private static int minCost(int[][] input, int rowIndex, int colIndex, int maxRowIndex, int maxColIndex) {
        if ((rowIndex >= maxRowIndex || colIndex >= maxColIndex)) { ////this is the base case
            return Integer.MAX_VALUE;
        } else if(rowIndex==maxRowIndex-1 && colIndex == maxColIndex-1) ////this is the Special Case
            return input[rowIndex][colIndex];


        int ans = input[rowIndex][colIndex] + Math.min( minCost(input, rowIndex, colIndex + 1, maxRowIndex, maxColIndex), Math.min(
                minCost(input, rowIndex+1, colIndex, maxRowIndex, maxColIndex),
                minCost(input, rowIndex+1, colIndex+1, maxRowIndex, maxColIndex) ) );

        return ans;
    }
}
