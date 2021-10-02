package org.datastructure.java.dynamicprogramming.smallestSuperSequence;

public class Solution1 {

    public static int smallestSuperSequence(String str1, String str2) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int smallestSuperSeq = superSeq(str1, str2, str1.length(),str2.length());
        return smallestSuperSeq;
    }

    private static int superSeq(String str1, String str2, int m, int n) {

        if(m==0) return n;
        if(n==0) return m;

        int superSeq=0;
        if(str1.charAt(m-1)==str2.charAt(n-1)) {
            superSeq = 1 + superSeq(str1, str2, m-1, n-1);
        } else {
            superSeq = 1 + Math.min( superSeq(str1, str2, m-1, n) ,
                    superSeq(str1, str2, m, n-1) );
        }

        return superSeq;
    }

}
