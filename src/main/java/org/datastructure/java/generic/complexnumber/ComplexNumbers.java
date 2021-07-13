package org.datastructure.java.generic.complexnumber;

/**
 *
 */
public class ComplexNumbers {

    public int real;
    public int imaginary;

    /**
     *
     * @param real
     * @param imaginary
     */
    public ComplexNumbers(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     *
     * @param complexNum
     */
    public void plus(ComplexNumbers complexNum) {
        this.real = (this.real + complexNum.real);
        this.imaginary = (this.imaginary + complexNum.imaginary);
    }

    /**
     *
     * @param complexNum
     */
    public void multiply(ComplexNumbers complexNum) {
        int real1 = ( (this.real * complexNum.real) - ( 1 * ( this.imaginary * complexNum.imaginary ) ) );
        this.imaginary = ( (this.real * complexNum.imaginary) + (this.imaginary * complexNum.real) );
        this.real = real1;
    }

    /**
     *
     */
    public void print() {
        System.out.println(this.real + " + " + ("i" + this.imaginary) );
    }

}
