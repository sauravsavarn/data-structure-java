package org.datastructure.java.dynamicprogramming.editDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String s = br.readLine().trim();
        String t = br.readLine().trim();


        //System.out.println(Solution1.editDistance(s, t));
        System.out.println(Solution2.editDistance(s, t));
    }
}
