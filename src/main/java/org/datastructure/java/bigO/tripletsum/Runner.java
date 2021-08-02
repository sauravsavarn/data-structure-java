package org.datastructure.java.bigO.tripletsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        System.out.println("Enter size of array : ");
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        System.out.println("Enter elements of array separated by space : ");
        strNums = br.readLine().split("\\s");


        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Enter number of test case to execute : ");
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] arr = takeInput();
            System.out.println("Enter a num as a comparator : ");
            int num = Integer.parseInt(br.readLine().trim());
            //System.out.println(Solution1.tripletSum(arr, num));
            //System.out.println(Solution2.tripletSum(arr, num));
            //System.out.println(Solution3.tripletSum(arr, num));
            //System.out.println(Solution4.tripletSum(arr, num));
            //System.out.println(Solution5.tripletSum(arr, num));
            //System.out.println(Solution6.tripletSum(arr, num));
            System.out.println(Solution7.tripletSum(arr, num));

            t -= 1;
        }
    }
}
