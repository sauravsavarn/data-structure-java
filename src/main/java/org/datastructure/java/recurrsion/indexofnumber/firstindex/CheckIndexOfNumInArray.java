package org.datastructure.java.recurrsion.indexofnumber.firstindex;

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
    public static int firstIndex(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(input.length == 0)
            return -1;

        if ( input.length == 1) {
            if (input[0] == x)
                return 0;
            else
                return -1;
        }

        if( input[input.length-1] == x) {
            // System.out.print("CURRENT_INDEX : " + (input.length -1) + " ");
            //// IF FOUND THEN CHECK AGAIN THE REST OF ARRAY TILL THE INDEX == 0, TO FIND ANY OTHER DUPLICATED NUMBERS
            int track=0;
            int[] subArr1 = new int[input.length-2];
            for (int i = 0; i < subArr1.length; i++) {
                subArr1[i] = input[i];
            }

            if( input.length != 0 ) {
                track = secondIndex(subArr1, x);
            }

            if(track == -1)
                return (input.length - 1);
        }

        int[] subArr = new int[input.length-1];
        for (int i = 0; i < subArr.length; i++) {
            subArr[i] = input[i];
        }

        int output = firstIndex(subArr, x);
        return output;

    }

    public static int secondIndex(int input[], int x) {
        if(input.length == 0)
            return -1;

        if ( input.length == 1) {
            if (input[0] == x)
                return 0;
            else
                return -1;
        }

        if( input[input.length-1] == x) {
            return (input.length - 1);
        }

        int[] subArr = new int[input.length-1];
        for (int i = 0; i < subArr.length; i++) {
            subArr[i] = input[i];
        }

        int output = firstIndex(subArr, x);
        return output;
    }

}