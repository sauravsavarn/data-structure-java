package org.datastructure.java.recurrsion.checknumberinarray.sol2;

/**
 *  NOTE: in this solution 2, we avoid creating n-1 element of array input[] into subArray of (n-1) size in every iteration.
 *
 *  NOTE: the idea is that checkNumber not only get the input array but also start-index.
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
    public static boolean checkNumber(int input[], int startingIndex, int x) {
        if ( startingIndex == input.length - 1) {
            if (input[startingIndex] == x)
                return true;
            else
                return false;
        }

        if (input[startingIndex] == x)
            return true;

        /* ** increment the startingIndex by 1 ** */
        startingIndex +=1;

        boolean output = checkNumber(input, startingIndex, x);
        return output;
    }
}