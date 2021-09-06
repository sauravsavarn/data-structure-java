package org.datastructure.java.testrounds.printThePattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Solution {

    static Vector<Integer> vector = new Vector<>();
    static HashMap<Integer, Vector<Integer>> hm = new HashMap<>();

    /* Input
     * n - number of rows */
    public static void printPattern(int n) {
        // Write your code here
        int k = 1;
        Vector<Integer> v = null;
        for (int i = 0; i < n * n; i++) {
            if ((i + n) % n == 0) {
                v = new Vector<>();
            }
            v.add(i + 1);

            if ((i + 1) % n == 0) {
                hm.put(k++, v);
            }
        }

        //////finally printing the output.
        for (Map.Entry<Integer, Vector<Integer>> ele : hm.entrySet()) {
            if (ele.getKey() % 2 != 0) {
                Vector<Integer> vec = ele.getValue();
                for (int i = 0; i < vec.size(); i++) {
                    System.out.print(vec.get(i) + " ");
                }
                System.out.println();
            }
        }
        for (int i = hm.keySet().size(); i >= 0; i--) {
            if (i % 2 == 0) {
                Vector<Integer> vec = hm.get(i);
                if (vec != null) {
                    for (int j = 0; j < vec.size(); j++) {
                        System.out.print(vec.get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
