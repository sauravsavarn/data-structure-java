package org.datastructure.java.recurrsion.quicksort;

import java.util.Scanner;

public class Runner {
    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        System.out.println("Enter total number of elements in array to be sorted using QuickSort : ");
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Enter element of array to be sorted usign QuickSort one-by-one : ");
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        QuickSort.quickSort(input);
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }


}
