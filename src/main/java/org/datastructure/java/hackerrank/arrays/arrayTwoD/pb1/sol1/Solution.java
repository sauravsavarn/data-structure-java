package org.datastructure.java.hackerrank.arrays.arrayTwoD.pb1.sol1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Solution {
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    int rowTraversed = 0;
    int columnTraversed = 0;
    static int sum=0;
    static Vector<Integer> result = new Vector<>();
    public static int hourglassSum(int[][] arr)  {
        //
        if(arr.length<3) //as to form hour glass minimum 3 elements are required
            return 0;

        for (int rowTraversed = 0; rowTraversed < arr.length-2; rowTraversed++) {

            for (int columnTraversed = 0; columnTraversed < arr.length-2;) {
                sum += arr[rowTraversed][columnTraversed]+
                        arr[rowTraversed][columnTraversed+1]+
                        arr[rowTraversed][columnTraversed+2]+
                        arr[rowTraversed+1][columnTraversed+1]+
                        arr[rowTraversed+2][columnTraversed]+
                        arr[rowTraversed+2][columnTraversed+1]+
                        arr[rowTraversed+2][columnTraversed+2];

                //finally adding this to result
                result.add(sum);

                //
                sum=0;
                columnTraversed++;
            }
        }

        /////now finding the max. value of hourglass from temp storage 'result'.
//        Collections.sort(result, Collections.reverseOrder());
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //reverse order
                return o2.compareTo(o1);
            }
        });

        /////thus max is the 1st element from DataStructure 'result'.
        return result.get(0);
    }
}
