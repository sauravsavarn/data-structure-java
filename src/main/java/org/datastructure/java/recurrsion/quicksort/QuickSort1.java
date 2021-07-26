package org.datastructure.java.recurrsion.quicksort;

public class QuickSort1 {

    public static void quickSort(int[] input) {

        int[] sortedOutput = quickSortt(input);
        int k = 0;
        for (int p: sortedOutput) {
            input[k++] = p;
        }
        System.out.println("testing is done");
    }

    public static int[] quickSortt(int[] input) {

        /////taking the base-case if startIndex < endIndex otherwise return, as if startIndex = endIndex signifies that there are only 1 element to be sorted which automatically is a sorted.
        int startIndex = 0;
        int endIndex = input.length;

        ///////// choosing the partition-key - by iterating to the array and check if any element is lower in value from the chosen random
        int chosenPartitionKeyValue = 0;
        for (int i = 0; i < input.length-1; i++) {
            if(input[i] > input[i+1] ) {
                chosenPartitionKeyValue = input[i];
                break;
            }
        }

        //////// finding the correct position of this partition-key which will have index = Σ(count-of-all-elements-smaller-than-this-value + 1)
        int reqPartitionKeyPosition = 0;
        for (int i = 0; i < input.length; i++) {
            if(chosenPartitionKeyValue > input[i])
                reqPartitionKeyPosition +=1;
        }

        System.out.println("Printing the required-partition-key-position : " + reqPartitionKeyPosition);

        /////////// realign the array-item based on this partition-key-position
        int[] intermArr = new int[input.length];
        int j=0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] < chosenPartitionKeyValue) {
                /* ** ** */
                intermArr[j++] = input[i];
            }
            if(i == reqPartitionKeyPosition) {
                intermArr[j++] = chosenPartitionKeyValue;
            }
        }
        for (int i = 0; i < input.length; i++) {
            if( input[i] > chosenPartitionKeyValue ) {
                /* ** ** */
                intermArr[j++] = input[i];
            }
        }
        System.out.println("Final Array Before calling QuickSort Recursively is : "  );
        int k =0;
        for (int p: intermArr) {
            input[k++] = p;
            System.out.print(" " + p);
        }

        ////// now calling quick-sort recursively
        return quickSortt(input);
    }
}
