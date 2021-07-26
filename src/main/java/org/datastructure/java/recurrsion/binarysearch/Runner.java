package org.datastructure.java.recurrsion.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Use runner to search in sorted-array using BinarySearch.
 */
public class Runner {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter elements in array in sorted manner : ");
        /* ** user-input to the array ** */
        int[] srcArray = Arrays.stream(reader.readLine().split("[\\s]")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter element to search for using BinarySearch : ");
        int elementToSearch = (new Scanner(System.in)).nextInt();
        /* ** ** */
        int indexOfSearchedElement = binarySearch(srcArray, 0, srcArray.length, elementToSearch);
        System.out.println("Index Of searched element : " + indexOfSearchedElement);
    }

    /**
     * @param srcArray
     * @param startIndex
     * @param endIndex
     * @param elementToSearch
     * @return
     */
    public static int binarySearch(int[] srcArray, int startIndex, int endIndex, int elementToSearch) {
        if (startIndex > endIndex)
            return -1;

        /* ** ** */
        int minIndex = (startIndex + endIndex) / 2;

        if (minIndex > srcArray.length-1)
            return -1;

        if (srcArray[minIndex] == elementToSearch)
            return minIndex;
        else if (srcArray[minIndex] > elementToSearch) {
            endIndex = minIndex - 1;

            /* ** ** */
            return binarySearch(srcArray, startIndex, endIndex, elementToSearch);
        } else {
            startIndex = minIndex + 1;

            /* ** ** */
            return binarySearch(srcArray, startIndex, endIndex, elementToSearch);
        }
    }

}
