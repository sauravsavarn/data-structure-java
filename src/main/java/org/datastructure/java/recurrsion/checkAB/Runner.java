package org.datastructure.java.recurrsion.checkAB;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to convert to Integer : ");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(checkAB(input));
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean checkAB(String input) {

        if(input.length() == 0){
            return true;
        }

        if(input.charAt(0) == 'a'){
            if(input.substring(1).length() > 1 && input.substring(1,3).equals("bb")){
                return checkAB(input.substring(3));
            }else{
                return checkAB(input.substring(1));
            }
        }
        return false;
    }
}
