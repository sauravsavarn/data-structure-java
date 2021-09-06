package org.datastructure.java.recurrsion.returnKeypadCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
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
    // Return a string array that contains all the possible strings
    public static String[] keypad(int n){
        // Write your code here
        dataFill(); ///////
        String[] output = keypadcode(n);
        return output;
    }

    private static String[] keypadcode(int num) {
        if( num/10==0 ) {
            String[] output = new String[hm.get(num).size()];
            for (int i = 0; i < hm.get(num).size(); i++) {
                output[i] = hm.get(num).get(i);
            }
            return output;
        }
        int lenghtOfNum = String.valueOf(num).length();
        int divisor = (int)Math.pow(10, lenghtOfNum-1);
        int quotient = num/divisor;
        int reminder = num - (quotient*divisor);
        String[] smallerOutput = keypadcode(reminder);

        String[] output = new String[smallerOutput.length * ( hm.get( Integer.parseInt(""+String.valueOf(num).charAt(0)) ).size() ) ];

        ///////now copy old output (i.e. smaller output)
        ArrayList<String> intermittent = hm.get(Integer.valueOf(""+String.valueOf(num).charAt(0)));
        for (int i = 0; i < smallerOutput.length; i++) {
            output[i] = smallerOutput[i];
        }
        int maxIndex=0; int listIndex=0;
        for (int i = 0; i < output.length; i++) {
            if(maxIndex>= smallerOutput.length){
                maxIndex=0;listIndex+=1;
            }
            output[i] = intermittent.get(listIndex) + smallerOutput[maxIndex];

            ///
            maxIndex++;
        }

        return output;
    }
}
