package org.datastructure.java.recurrsion.printKeypadCode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution1 {
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
    public static void printKeypad(int n){
        // Write your code here
        dataFill(); ///////
        keypadcode(""+n, "");
        System.out.println("PRINTING ALL POSSIBLE COMBINATIONS : ");
        aList.listIterator().forEachRemaining(x -> System.out.println(x));
    }

    static ArrayList<String> aList = new ArrayList<>();
    private static void keypadcode(String num, String keypadSoFar) {
        if( num.length()==0 ) {

            if(keypadSoFar.length()==1 && !keypadSoFar.isEmpty() && aList.isEmpty()) {
                for (int i = 0; i < hm.get(Integer.valueOf(keypadSoFar)).size(); i++) {
                    aList.add(hm.get(Integer.valueOf(keypadSoFar)).get(i));
                }
            } else if(keypadSoFar.length()==1 && !keypadSoFar.isEmpty() && !aList.isEmpty()) {
                ArrayList<String> interim = new ArrayList<>();
                for (int i = 0; i < aList.size(); i++) {
                    interim.add(aList.get(i));
                }
                aList.clear();
                for (int i = 0; i < hm.get(Integer.valueOf(keypadSoFar)).size(); i++) {
                    for (int j = 0; j < interim.size(); j++) {
                        aList.add(hm.get(Integer.valueOf(keypadSoFar)).get(i)+ interim.get(j));
                    }
                }
            }
            return;
        }

        String smallerInput = num.substring(1);
        keypadcode(smallerInput, keypadSoFar);
        keypadcode(smallerInput, keypadSoFar+num.charAt(0));
    }
}
