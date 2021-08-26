package org.datastructure.java.priorityQueue.implementPriorityQueueMin;

/**
 * @param <T>
 */
public class Element<T> {
    T value;
    int priority;

    public Element(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
