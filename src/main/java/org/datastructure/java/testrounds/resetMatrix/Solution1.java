package org.datastructure.java.testrounds.resetMatrix;

import java.util.Vector;

public class Solution1 {
    static int colIndex=-1; static int rowIndex=-1;
    static Vector<Integer> vectorRowIndexes = new Vector<>();
    static Vector<Integer> vectorColIndexes = new Vector<>();
    public static void makeRowsCols0(int [][]input) {
        // Write your code here
        int[][] output = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if(input[i][j]==0) {
                    //////preserve this value
                    vectorRowIndexes.add(i); vectorColIndexes.add(j);
                    //colIndex=j;rowIndex=i;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if(i==rowIndex || vectorRowIndexes.contains(i)) {
                    output[i][j] = 0;
                    //System.out.print(0 + " ");
                } else if ( (i!= rowIndex && colIndex==j) || (!vectorRowIndexes.contains(i) && vectorColIndexes.contains(j)  ) ) {
                    output[i][j] = 0;
                    //System.out.print(0 + " ");
                }
                else {
                    output[i][j] = input[i][j];
                    //System.out.print(input[i][j] + " ");
                }
            }
            //System.out.println("");
        }

        /////now copy all elements from output back to input;
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                input[i][j] = output[i][j];
            }
        }
    }
}
