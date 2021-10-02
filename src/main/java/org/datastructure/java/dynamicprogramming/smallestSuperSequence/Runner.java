package org.datastructure.java.dynamicprogramming.smallestSuperSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        //int min_len = Solution1.smallestSuperSequence(str1, str2);
        int min_len = Solution2.smallestSuperSequence(str1, str2);
        System.out.print(min_len);
    }
}
