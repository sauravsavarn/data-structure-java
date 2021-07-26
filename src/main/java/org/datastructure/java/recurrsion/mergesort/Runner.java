package org.datastructure.java.recurrsion.mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Implementing class to show behaviour of MergeSort algorithm
 */
public class Runner {

    static int k=0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter elements in array to sort : ");
        int[] sourceArr = Arrays.stream(reader.readLine().split("[ ]")).mapToInt(Integer::parseInt).toArray();
        int[] finalArr = new int[sourceArr.length];

        System.out.println("Sorted Array : ");
        for (int arrElement : mergeSort(sourceArr/*, 0, sourceArr.length-1*/) ) {
            System.out.print(arrElement + " ");
        }
    }

    public static int[] mergeSort(int[] sourceArr /*, int startIndex, int endIndex*/) {
//        if(sourceArr.length==1)
//            return sourceArr;
        int startIndex=0;
        int endIndex= sourceArr.length-1;
        if(startIndex < endIndex) {
            int meanIndex = (startIndex + endIndex) / 2;

            int[] interimArray1 = Arrays.copyOfRange(sourceArr, 0, meanIndex+1);
            int[] interimArray2 = Arrays.copyOfRange(sourceArr, meanIndex + 1, endIndex+1);

            int[] temp1 = mergeSort(interimArray1/*, 0, meanIndex*/);
            int[] temp2 = mergeSort(interimArray2/*, meanIndex + 1, endIndex*/);

            return merge(temp1, temp2);
        }

        return sourceArr;
    }

    public static int[] merge(int[] sourceArr1, int[] sourceArr2) {
        /* ** ** */
        int[] finalArr = new int[sourceArr1.length+ sourceArr2.length];

        /* ** ** */
        int k=0; //finalArr index
        int i = 0; //sourceArr1 index
        int j = 0; //sourceArr2 index

        while(k!= finalArr.length) {
            if(j != sourceArr2.length && i != sourceArr1.length) {
                if (sourceArr1[i] <= sourceArr2[j]) {
                    finalArr[k++] = sourceArr1[i];
                    i++;
                } else {
                    finalArr[k++] = sourceArr2[j];
                    j++;
                }
            } else {
                break;
            }
        }
        if(j != sourceArr2.length) {
            ///then copy element one by one
            for (int l = j; l < sourceArr2.length; l++) {
                finalArr[k++] = sourceArr2[l];
            }
        }
        if(i != sourceArr1.length) {
            ///then copy element one by one
            for (int l = i; l < sourceArr1.length; l++) {
                finalArr[k++] = sourceArr1[l];
            }
        }

        return finalArr;
    }

    public static int[] merge1(int[] sourceArr1, int[] sourceArr2) {
        /* ** ** */
        int[] finalArr = new int[sourceArr1.length+ sourceArr2.length];

        /* ** ** */
        int k=0;
        if(sourceArr1.length > sourceArr2.length) {
            for (int i: sourceArr2) {

                for (int j: sourceArr1) {
                    if(i<j) {
                        finalArr[k++] = i;
                        finalArr[k++] = j;
                    } else {
                        finalArr[k++] = j;
                    }
                }

                if(Arrays.stream(finalArr).anyMatch(x-> x != i)) {
                    finalArr[k++] = i;
                }

            }
        } else {
            for (int i: sourceArr1) {

                for (int j: sourceArr2) {
                    if(i<j) {
                        finalArr[k++] = i;
                        finalArr[k++] = j;
                    } else {
                        finalArr[k++] = j;
                    }
                }

                if(Arrays.stream(finalArr).anyMatch(x-> x != i)) {
                    finalArr[k++] = i;
                }
            }
        }

        return finalArr;
    }

}
