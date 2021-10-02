package org.datastructure.java.dynamicprogramming.longestCommonSubsequence;


import java.util.HashMap;

/////Iteratively approach with Memoization (Dynamic Programming) ---- this Solution is Incomplete & giving error.
///// Needs to Implement this solution correctly.
public class Solution5 {

    private static HashMap<String, Integer> hm = new HashMap<>();

    public static int lcs(String s, String t) {
        //Your code goes here
        hm.put("", 0);
//        if (s.charAt(s.length() - 1) == t.charAt(t.length() - 1))
//            hm.put("" + s.charAt(s.length() - 1) + t.charAt(t.length() - 1), 1);
//        else hm.put("" + s.charAt(s.length() - 1) + t.charAt(t.length() - 1), 0);
        hm.put("" + s.charAt(s.length() - 1), 0);
        hm.put("" + t.charAt(t.length() - 1), 0);

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {

                if (!hm.containsKey(s.substring(i + 1) + t.substring(j))) {
                    //System.out.println("Key note found");
                    hm.put(s.substring(i + 1) + t.substring(j), 0);
                }
                if (!hm.containsKey(s.substring(i) + t.substring(j + 1))) {
                    //System.out.println("Key note found");
                    hm.put(s.substring(i) + t.substring(j + 1), 0);
                }

                int ans = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    if( (s.substring(i)+t.substring(j)).equals("abcdbbcacdhb")) {
                        System.out.println("Match Found!");
                    }
                    ans = 1 + Math.max(hm.get(s.substring(i + 1) + t.substring(j)), hm.get(s.substring(i) + t.substring(j + 1)));
                } else {
                    if( (s.substring(i)+t.substring(j)).equals("abcdbbcacdhb")) {
                        System.out.println("Match Found!");
                    }
                    ans = Math.max(hm.get(s.substring(i + 1) + t.substring(j)), hm.get(s.substring(i) + t.substring(j + 1)));
                }

                hm.put(s.substring(i) + t.substring(j), ans);
            }
        }

        int ans = hm.get(s + t);
        return ans;
    }
}
