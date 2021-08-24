package org.datastructure.java.hashmaps.extractUniqueCharacters;

import java.util.HashMap;

public class Solution {

    static HashMap<Character, Character> hm = new HashMap<>();
    public static String uniqueChar(String str){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(str.length()==0)return str;

        for (char charElemenet: str.toCharArray()) {
            if(!hm.containsKey(charElemenet))
                hm.put(charElemenet, charElemenet);
        }

        StringBuffer sBuf = new StringBuffer();
        for (char charElemenet: str.toCharArray()) {
            if(hm.containsKey(charElemenet)) {
                sBuf.append(charElemenet);hm.remove(charElemenet);
            }
        }

        return sBuf.toString();
    }
}