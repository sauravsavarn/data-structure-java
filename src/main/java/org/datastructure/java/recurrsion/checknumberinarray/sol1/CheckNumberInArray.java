package org.datastructure.java.recurrsion.checknumberinarray.sol1;

/**
 *  NOTE: in this solution 1, we use subArray's which is (n-1) copy of array input[]
 */
public class CheckNumberInArray {

    /**
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     *
     * @param input
     * @param x
     * @return
     */
    public static boolean checkNumber(int input[], int x) {
        if (input.length == 1) {
            if (input[0] == x)
                return true;
            else
                return false;
        }

        if (input[0] == x)
            return true;

        int[] subArray = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            subArray[i - 1] = input[i];
        }

        boolean output = checkNumber(subArray, x);
        return output;
    }
}