package org.datastructure.java.dynamicprogramming.editDistance;

/////Recursive approach (without any Dynamic Programming concept)
public class Solution1 {

    public static int editDistance(String s, String t) {
        //Your code goes here
        int editDistance = editDist(s, t, s.length(), t.length());
        return editDistance;
    }

    private static int editDist(String str1, String str2, int m,
                                int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1
                + Math.min(editDist(str1, str2, m, n - 1), // Insert
                Math.min(editDist(str1, str2, m - 1, n), // Remove
                        editDist(str1, str2, m - 1,
                                n - 1) // Replace
                ));
    }
}
