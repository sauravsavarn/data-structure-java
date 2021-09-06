package org.datastructure.java.testrounds.printMatrixDiagonally;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt(),n=s.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=s.nextInt();
            }
        }
        //Solution1.printInDiagonalForm(arr);
        Solution2.printInDiagonalForm(arr);
        s.close();
    }
}
