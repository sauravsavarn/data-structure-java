package org.datastructure.java.testrounds.printMatrixDiagonally;

import java.util.Collections;
import java.util.Vector;

public class Solution2 {
    static final int MAX = 100;

    public static void printInDiagonalForm(int[][] arr) {
        //Write your code here

        int sizeOfMatrix = arr.length;
        printMatrix(arr);
    }

    // n - size
    // mode - switch to derive up/down traversal
    // it - iterator count - increases until it
    // reaches n and then decreases
    private static void printMatrix(int[][] matrix) {
        int row, col;
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        int [] arr = new int[rowCount*columnCount]; int index=0;
        Vector<Integer> temp = new Vector<>();
        for (int k = 0; k < rowCount; k++) {
            ////when there is a row change- check for vector
            if(temp!=null && !temp.isEmpty()) {
                for (int i = temp.size()-1; i >=0 ; i--) {
                    arr[index++] = temp.get(i);
                }
                temp.clear();
            }
            for (row = k, col = 0; row >= 0 && col < columnCount; row--, col++) {
                if(row%2!=0) {
                    arr[index++] = matrix[row][col];
                } else {
                    temp.add(matrix[row][col]);
                }
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

//        for (int k = 1; k < columnCount; k++) {
//            for (row = rowCount - 1, col = k; row >= 0 && col < columnCount; row--, col++) {
//                System.out.print(matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
    }
}
