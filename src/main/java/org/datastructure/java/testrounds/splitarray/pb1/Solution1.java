package org.datastructure.java.testrounds.splitarray.pb1;

public class Solution1 {
    static int partA=0;
    static int partB=0;
    static boolean isPossible = false;
    public static boolean splitArray(int input[]) {

        for (int itmArr: input) {
            if(itmArr%5 == 0) {
                partA += itmArr;

            } else if(itmArr%3 == 0 && itmArr%5 == 0) {
                partB += itmArr;
            }
        }

        for (int i = 0; i < input.length; i++) {
            if(input[i]%3 != 0 && input[i]%5 != 0) {

            }
        }

        return false; //this problem is incomplete
    }

}
