package org.datastructure.java.recurrsion.printKeypadCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {
    ///////keypad
    static HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
    private static void  dataFill() {
        //hm.put(1, new ArrayList<>(Arrays.asList('A', 'B', 'C')));
        hm.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        hm.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        hm.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        hm.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        hm.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        hm.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        hm.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        hm.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    public static void printKeypad(int input){
        // Write your code here
        dataFill(); ///////
        keypadcode(input, "");
    }

    private static void keypadcode(int input, String stringSoFar) {
        if(input==0) {
            System.out.println(stringSoFar);return;
        }

        int lastDigit = input%10;
        int smallInput = input/10;

        for (int i = 0; i < hm.get(lastDigit).size(); i++) {
            keypadcode(smallInput, hm.get(lastDigit).get(i) + stringSoFar);
        }
    }
}
