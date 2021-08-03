package org.datastructure.java.hackerrank.arrays.arrayTwoD.pb1.sol1;

import java.io.*;

public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter ROWS of array : ");
        int sizeRow = Integer.parseInt(br.readLine().trim());
        System.out.println("Enter COLUMNS of array : ");
        int sizeColumn = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[sizeRow][sizeColumn];

        for (int i = 0; i < sizeRow; i++) {
            String[] strNums;
            System.out.println("Enter elements of array separated by space : ");

            strNums = br.readLine().split("\\s");
            for (int j = 0; j < sizeColumn; j++) {
                input[i][j] = Integer.parseInt(strNums[j]);
            }
        }

        System.out.println(Solution.hourglassSum(input));
    }
}
