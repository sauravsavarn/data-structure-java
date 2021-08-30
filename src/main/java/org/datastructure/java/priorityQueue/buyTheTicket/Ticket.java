package org.datastructure.java.priorityQueue.buyTheTicket;

public class Ticket {
    int priority;
    int index;
    boolean destinedElement = false;

    public Ticket(int priority, int index, boolean destinedElement) {
        this.priority = priority;
        this.index = index;
        this.destinedElement = destinedElement;
    }
}
