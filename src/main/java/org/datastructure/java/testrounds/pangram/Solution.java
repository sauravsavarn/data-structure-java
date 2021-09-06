package org.datastructure.java.testrounds.pangram;

public class Solution {

    public static void ans(int n, String str) {
        //Write your code here
        if(checkPangram(str)) System.out.println("YES");
        else System.out.println("NO");
    }


    // Returns true if the string
    // is pangram else false
    public static boolean checkPangram(String str) {
        // Create a hash table to mark the
        // characters present in the string
        // By default all the elements of
        // mark would be false.
        boolean[] mark = new boolean[26];

        // For indexing in mark[]
        int index = 0;

        // Traverse all characters
        for (int i = 0; i < str.length(); i++) {
            // If uppercase character, subtract 'A'
            // to find index.
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                index = str.charAt(i) - 'A';

                // If lowercase character, subtract 'a'
                // to find index.
            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')

                index = str.charAt(i) - 'a';

                // If this character is other than english
                // lowercase and uppercase characters.
            else
                continue;
            mark[index] = true;
        }

        // Return false if any character is unmarked
        for (int i = 0; i <= 25; i++)
            if (mark[i] == false)
                return (false);

        // If all characters were present
        return (true);
    }
}
