package org.datastructure.java.testrounds.printMatrixDiagonally;

public class Solution1 {
    public static void printInDiagonalForm(int[][] arr) {
        //Write your code here

        int sizeOfMatrix = arr.length;
        printMatrix(arr, sizeOfMatrix, 0, 0, 0);
    }

    // n - size
    // mode - switch to derive up/down traversal
    // it - iterator count - increases until it
    // reaches n and then decreases
    private static void printMatrix(int[][] arr, int n, int mode, int it, int lower) {
        // 2n will be the number of iterations
        for (int t = 0; t < (2 * n - 1); t++) {
            int t1 = t;
            if (t1 >= n) {
                mode++;
                t1 = n - 1;
                it--;
                lower++;
            }
            else {
                lower = 0;
                it++;
            }
            for (int i = t1; i >= lower; i--) {
                if ((t1 + mode) % 2 == 0) {
                    System.out.print(arr[i][t1 + lower - i] + " ");
                }
                else {
                    System.out.print(arr[t1 + lower - i][i] + " ");
                }
            }
        }
    }
}
