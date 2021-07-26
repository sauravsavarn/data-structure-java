package org.datastructure.java.recurrsion.calculatepower;

/**
 *
 */
public class CalculatePower {

    int x;
    int n;

    /**
     *
     * @param x
     * @param n
     */
    public CalculatePower(int x, int n) {
        this.x = x;
        this.n = n;
    }

    /**
     *
     * @param base
     * @param power
     * @return
     */
    public int calculatePower(int base, int power) {

        if( (power == 0 && base != 0) || (base == 0 && power == 0) )
            return 1;
        if(base == 0)
            return 0;

        if(power == 1)
            return base;

        int intermediateResults = base * calculatePower(base, power-1);

        int output = intermediateResults;

        return output;
    }
}
