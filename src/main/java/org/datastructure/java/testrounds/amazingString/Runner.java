package org.datastructure.java.testrounds.amazingString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Runner {
    private static int t;
    private static ArrayList<String[]> allArrays;



    private static void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().split(" ")[0]);


        allArrays = new ArrayList<>(t);


        String[] data;
        for (int i = 0; i < t; i++) {
            data = br.readLine().split(" ");
            String a[] = data;

            allArrays.add(a);

        }
    }

    private static void execute() {
        ArrayList<String[]> allArraysCopy = new ArrayList<>(allArrays);

        for (int i = 0; i < t; i++) {
            String ans = Solution.amazingStrings(allArraysCopy.get(i)[0], allArraysCopy.get(i)[1], allArraysCopy.get(i)[2]);
        }
    }

    private static void executeAndPrintOutput() {

        for (int i = 0; i < t; i++) {
            String result = Solution.amazingStrings(allArrays.get(i)[0], allArrays.get(i)[1], allArrays.get(i)[2]);

            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        takeInput();
        executeAndPrintOutput();
    }
}

