package org.datastructure.java.hackerrank.arrays.arrayTwoD.pb1.sol2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Solution {
    static int sum = 0;
    static Vector<Integer> result = new Vector<>();
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        if (arr.size() < 3) //as to form hour glass minimum 3 elements are required
            return 0;

        for (int rowTraversed = 0; rowTraversed < arr.size() - 2; rowTraversed++) {

            for (int columnTraversed = 0; columnTraversed < arr.get(rowTraversed).size() - 2; ) {
                sum += (arr.get(rowTraversed)).get(columnTraversed) +
                        (arr.get(rowTraversed)).get(columnTraversed + 1) +
                        (arr.get(rowTraversed)).get(columnTraversed + 2) +
                        (arr.get(rowTraversed + 1)).get(columnTraversed + 1) +
                        (arr.get(rowTraversed + 2)).get(columnTraversed) +
                        (arr.get(rowTraversed + 2)).get(columnTraversed + 1) +
                        (arr.get(rowTraversed + 2)).get(columnTraversed + 2);

                //finally adding this to result
                result.add(sum);

                //
                sum = 0;
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
