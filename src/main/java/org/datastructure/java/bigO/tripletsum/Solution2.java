package org.datastructure.java.bigO.tripletsum;

public class Solution2 {
    static int tripletCount = 0;
    static int leftIndex=0;
    static int rightIndex=0;
    public static int tripletSum(int[] arr, int num) {

        ///////////init left & right index
        leftIndex = 0;
        rightIndex = arr.length-1;

        ///////////sort array
//        Arrays.sort(arr);

        ///////////Now fix the first element one by one and find the other two elements
        for (int i = 0; i < arr.length-2; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other

            //if(i==0) {
                leftIndex = i + 1; // index of the first element in the remaining elements
                //rightIndex = arr.length - 1; // index of the last element
                rightIndex = leftIndex+1;
            //} else {
            //    leftIndex = 0; // index of the first element in the array
            //    rightIndex = arr.length - 1; // index of the last element
            //}
            while (leftIndex < rightIndex) {
                if (arr[i] + arr[leftIndex] + arr[rightIndex] == num) {
                    //System.out.println("Triplet is " + arr[i] + ", " + arr[leftIndex] + ", " + arr[rightIndex]);
                    tripletCount++;
                    //leftIndex++;
                    rightIndex++;

                    if(rightIndex > arr.length && leftIndex< rightIndex) {
                        leftIndex++;
                    }
                }
                else if (arr[i] + arr[leftIndex] + arr[rightIndex] != num) {
                    rightIndex++;
                }

                if(rightIndex == arr.length-1 && leftIndex< rightIndex) {
                    if (arr[i] + arr[leftIndex] + arr[rightIndex] == num) {
                        //System.out.println("Triplet is1 " + arr[i] + ", " + arr[leftIndex] + ", " + arr[rightIndex]);
                        tripletCount++;
                        rightIndex++;
                    } else {
                        leftIndex += 1;
                        rightIndex = leftIndex + 1;
                    }

                    if(rightIndex >= arr.length && leftIndex< rightIndex) {
                        leftIndex++;
                        rightIndex = leftIndex + 1;
                    }

                }

                if(rightIndex> arr.length-1)
                    break;

            }
        }

        /* ** ** */
        return tripletCount;
    }
}
