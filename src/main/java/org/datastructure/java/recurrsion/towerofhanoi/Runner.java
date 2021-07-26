package org.datastructure.java.recurrsion.towerofhanoi;

import java.util.Scanner;

/**
 * Base Case if n==1, move the nth element to destination rod
 *
 * for n-1 element, move this from rod 'A' to rod 'B' taking rod 'C' as helper.
 *
 * Simply move nth element to rod 'C' (i.e. from Source rod to Destination rod)
 *
 * for n-1 element, move this from rod 'B' to rod 'C' taking rod 'A' as helper.
 *
 */
public class Runner {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Enter total number of disks : ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        towerOfHanoi(n, 'a', 'b', 'c');
    }

    /**
     *
     * @param disks
     * @param source
     * @param auxiliary
     * @param destination
     */
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        if(disks <= 0)
            return;
        if(disks == 1) {
            System.out.println(source + " " + destination);
            return;
        }

        towerOfHanoi(disks-1, source, destination, auxiliary);
        System.out.println(source + " " + destination);
        towerOfHanoi(disks-1, auxiliary, source, destination);
    }
}
