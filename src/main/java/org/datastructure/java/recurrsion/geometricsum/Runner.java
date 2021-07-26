package org.datastructure.java.recurrsion.geometricsum;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        double ans = findGeometricSum(k);
        DecimalFormat dec = new DecimalFormat("#0.00000");
        System.out.println(dec.format(ans));
    }

    public static double findGeometricSum(int k){
        // Write your code here
        if(k==0)
            return 1;

        double temp = (1.0/Math.pow(2, k)) + findGeometricSum(k-1);
        return temp;
    }

}
