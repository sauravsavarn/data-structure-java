package org.datastructure.java.testrounds.amazingString;

import java.util.Vector;

public class Solution {

    public static String amazingStrings(String first, String second, String third) {
        // Write your code here.
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        char[] thirdArr = third.toCharArray();

        Vector<String> firstVec = new Vector<>();
        Vector<String> secondVec = new Vector<>();
        for (int i = 0; i < firstArr.length; i++) {
            firstVec.add(""+firstArr[i]);
        }
        for (int i = 0; i < secondArr.length; i++) {
            secondVec.add(""+secondArr[i]);
        }

        //////now check one by one usign third string
        for (int i = 0; i < thirdArr.length; i++) {
            char element = thirdArr[i];

            if(firstVec.contains(""+element)) {
                firstVec.remove(""+element);
            } else if(secondVec.contains(""+element)) {
                secondVec.remove(""+element);
            } else {
                return "NO";
            }
        }

        if(firstVec.isEmpty() && secondVec.isEmpty())
            return  "YES";
        else
            return "NO";
    }
}
