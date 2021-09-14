package org.datastructure.java.backtracking.nQueens;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //Solution1.placeNQueens(n);
        Solution2.placeNQueens(n);
    }
}
