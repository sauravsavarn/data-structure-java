package org.datastructure.java.testrounds.resetMatrix;

import java.util.Scanner;

public class Runner {
    static Scanner s = new Scanner(System.in);


    public static int[][] takeInput2D(){

        int numRows = s.nextInt();
        int numCols = s.nextInt();
        int[][] input = new int[numRows][numCols];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                input[i][j] = s.nextInt();
            }
        }
        return input;
    }

    public static void print(int input[][]) {
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int input[][] = takeInput2D();
        //Solution1.makeRowsCols0(input);
        Solution2.makeRowsCols0(input);
        print(input);
    }
}
