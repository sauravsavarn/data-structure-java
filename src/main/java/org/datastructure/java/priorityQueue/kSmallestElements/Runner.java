package org.datastructure.java.priorityQueue.kSmallestElements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> output = Solution.kSmallest(n, input, k);
        Collections.sort(output);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

}