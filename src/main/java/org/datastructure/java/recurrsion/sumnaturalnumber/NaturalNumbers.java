package org.datastructure.java.recurrsion.sumnaturalnumber;

/**
 * To calculate sum of (N) Natural Numbers.
 */
public class NaturalNumbers {
    int inputNumber;

    public NaturalNumbers() {

    }

    public NaturalNumbers(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    /**
     *
     * @param num
     * @return
     */
    public int calculateUsingRecurrsion(int num) {

        if(num == 0)
            return num;

        int intermediateResults = calculateUsingRecurrsion(num-1);
        int output = num + intermediateResults;

        return output;
    }
}
