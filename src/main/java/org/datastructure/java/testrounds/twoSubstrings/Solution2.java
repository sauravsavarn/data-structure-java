package org.datastructure.java.testrounds.twoSubstrings;

import java.util.Vector;

public class Solution2 {
    static Vector<String> vector = new Vector<>(2);

    public static void twoSubstrings(String s) {
        // Write your code here
        if (checkSubstrings(s)) System.out.println("YES");
        else System.out.println("NO");
    }

    // Function that returns true, if s contains two non overlapping sub Strings "geek" and "keeg"
    static boolean checkSubstrings(String s)
    {
        // If "geek" and "keeg" are both present in s without over-lapping and "keeg" starts after "geek" ends
        if ((s.indexOf( "AB")!=-1) ) {
            //////removing 'AB'
            StringBuffer sb = new StringBuffer(s);
            sb.delete(s.indexOf("AB"),s.indexOf("AB")+2);

            if(sb.toString().indexOf("BA")!=-1)
                return true;
            else
                return false;
        }
        return false;


    }
}
