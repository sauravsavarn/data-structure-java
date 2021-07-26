package org.datastructure.java.recurrsion.countzeros;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter numbers to count zeros : ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countZerosRec(n));
    }

    public static int countZerosRec(int input){
        if(input>= 1 && input<=9)
            return 0;
        if(input ==0)
            return 1;

        //int numOfZeros = countZerosRec(Integer.parseInt((""+input).substring(1)));
        int numOfZeros = ((""+input).substring(1).length() - (""+(Integer.parseInt( (""+input).substring(1) ))).length() ) + countZerosRec( Integer.parseInt((""+input).substring(0,1))  ) + countZerosRec( Integer.parseInt((""+input).substring(1))  );

        return numOfZeros;
    }
}
