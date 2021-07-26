package org.datastructure.java.recurrsion.indexofnumber.lastindex;

/**
 *
 */
public class CheckIndexOfNumInArray {

    /**
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     *
     * @param input
     * @param x
     * @return
     */
    public static int lastIndex(int input[], int x) {

        if (input.length == 0)
            return -1;

        if (input.length == 1) {
            if (input[0] == x)
                return 0;
            else
                return -1;
        }

        if (input[input.length - 1] == x) {
            // System.out.print("CURRENT_INDEX : " + (input.length -1) + " ");
            return (input.length - 1);
        }

        int[] subArr = new int[input.length - 1];
        for (int i = 0; i < subArr.length; i++) {
            subArr[i] = input[i];
        }

        int output = lastIndex(subArr, x);
        return output;

    }
}