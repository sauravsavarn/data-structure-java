package org.datastructure.java.priorityQueue.implementPriorityQueueMin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int choice = Integer.parseInt(st.nextToken());
        while(choice != -1) {
            switch(choice) {
                case 1 : // insert
                    System.out.println("Enter value of the Element : ");
                    int value = scanner.nextInt();
                    System.out.println("Enter priority of the Element : ");
                    int priority = scanner.nextInt();
                    pq.insert(value, priority);
                    break;
                case 2 : // getMin
                    try {
                        System.out.println(pq.getMinimum());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 3 : // removeMin
                    try {
                        System.out.println(pq.removeMinimum());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 4 : // size
                    System.out.println(pq.size());
                    break;
                case 5 : // isEmpty
                    System.out.println(pq.isEmpty());
                case 6: //print
                    pq.printAll();
                    break;
                default :
                    return;
            }
            System.out.println("Enter next token : ");
            choice = scanner.nextInt();
        }
    }

}