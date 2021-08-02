package org.datastructure.java.testrounds.splitarray.pb1;

public class Solution2 {
    static int partA = 0;
    static int partB = 0;
    static boolean isPossible = false;
    static int startIndex = 0;

    public static boolean splitArray(int input[]) {

        //if reached to the end
        if (startIndex == input.length - 1) {
            return partA == partB;
        }

        if (input[startIndex] % 5 == 0) {
            partA += input[startIndex];
        } else if (input[startIndex] % 3 == 0 && input[startIndex] % 5 == 0) {
            partB += input[startIndex];
        } else {
            //increment the startIndex
            startIndex+=1;

            //Try adding in both the Σhalves (one by one) and check whether the condition satisfies
            partA += input[startIndex];
            boolean bool1 = splitArray(input);
            partB += input[startIndex];
            boolean bool2 = splitArray(input);

            return bool1 == bool2;
        }

        //increment the startIndex
        startIndex+=1;
        return splitArray(input);
    }
}
