package org.datastructure.java.recurrsion.returnSubsequences;

public class Solution {


    public String[] subsequences(String word) {
        ////base case
        if (word.isEmpty()) {
            String output[] = new String[1];
            output[0] = "";
            return output;
        }
        ////otherwise
        String[] smallerOutput = subsequences(word.substring(1));
        String[] output = new String[smallerOutput.length * 2];

        for (int i = 0; i < smallerOutput.length; i++) {
            output[i] = smallerOutput[i];
        }
        for (int i = 0; i < smallerOutput.length; i++) {
            output[smallerOutput.length + i] = word.charAt(0) + smallerOutput[i];
        }

        return output;
    }
}
