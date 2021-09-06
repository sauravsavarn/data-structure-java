package org.datastructure.java.testrounds.twoSubstrings;

import java.util.Vector;

public class Solution1 {
    static Vector<String> vector = new Vector<>(2);

    public static void twoSubstrings(String s) {
        // Write your code here
        vector.add("AB");
        vector.add("BA");
        checkSubstrings(s);
        if (vector.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }

    private static String checkSubstrings(String s) {
        if (s.length() == 1) return s;

        String smallerOutput = checkSubstrings(s.substring(1));

        boolean isFound = false;
        if (!smallerOutput.isEmpty()) {
            if (("" + s.charAt(0) + smallerOutput.charAt(0)).equals("AB")) {
                if(vector.contains("AB")) {
                    vector.remove("AB");
                    isFound = true;
                }
            } else if (("" + s.charAt(0) + smallerOutput.charAt(0)).equals("BA")) {
                if(vector.contains("BA")) {
                    vector.remove("BA");
                    isFound = true;
                }
            }
        } else {
            return ""+s.charAt(0);
        }

        if (!isFound)
            return ("" + s.charAt(0) + smallerOutput);
        else {
            return s.substring(2);
        }
    }
}
