package org.datastructure.java.generic.polynomial;

import java.util.Iterator;
import java.util.Vector;

public class Polynomial {
    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */
//    Vector vector;
    int sizeOfArray = 4;
    int[] vector;

    public Polynomial() {
        vector  = new int[sizeOfArray];
    }

    public void setCoefficient(int degree, int coeff) {
        /* ** ** */
        if(degree > vector.length-1)
        {
            //needs to increase the array-size

            int arr[] = new int[2 * degree];
            //now copy from prev arr to this arr;
            for (int i = 0; i < vector.length; i++) {
                arr[i] = vector[i];
            }
            //finally assign this temp arr to vector.
            this.vector = null;
            this.vector = arr;
            this.sizeOfArray = this.vector.length;
        }
        vector[degree] = coeff;
    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.
    public void print() {
        for (int i = 0; i < vector.length ; i++) {
            if(vector[i] != 0)
                System.out.print(vector[i] + ("x"+i) + " " );
        }

    }

    /**
     * Adds two polynomials and returns a new polynomial which has result
     * @param p
     * @return
     */
    public Polynomial add(Polynomial p) {
        int maxCapacity = 0;
        int temp = 0;
        Polynomial newPolynomial = new Polynomial();

        if(p.vector.length > this.vector.length) {
            maxCapacity = p.vector.length;

            for (int i = 0; i < maxCapacity; i++) {
                temp = (Integer) p.vector[i];

                if(i < this.vector.length) {
                    newPolynomial.setCoefficient(i, ( temp + (Integer) this.vector[i] ));
                } else {
                    newPolynomial.setCoefficient(i, temp);
                }
            }

        } else {
            maxCapacity = this.vector.length;

            for (int i = 0; i < maxCapacity; i++) {
                temp = (Integer) this.vector[i];

                if(i < p.vector.length) {
                    newPolynomial.setCoefficient(i, ( temp + (Integer) p.vector[i] ) );
                } else {
                    newPolynomial.setCoefficient(i, temp);
                }
            }
        }

        /* ** ** */
        return newPolynomial;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {
        int maxCapacity = 0;
        Polynomial newPolynomial = new Polynomial();

        if(p.vector.length > this.vector.length) {
            maxCapacity = p.vector.length;

            /* ** ** */
            for (int i = 0; i < maxCapacity; i++) {

                if(i < this.vector.length) {
                    newPolynomial.setCoefficient(i, ( ((Integer)this.vector[i] )) - ((Integer) p.vector[i])  );
                } else {
                    newPolynomial.setCoefficient(i, -1 * ((Integer) p.vector[i])  );
                }
            }

        } else {
            maxCapacity = this.vector.length;

            /* ** ** */
            for (int i = 0; i < maxCapacity; i++) {

                if(i < p.vector.length) {
                    newPolynomial.setCoefficient(i, ( ((Integer)this.vector[i] )) - ((Integer) p.vector[i])  );
                } else {
                    newPolynomial.setCoefficient(i, 1 * ((Integer) this.vector[i] )  );
                }
            }
        }

        /* ** ** */
        return newPolynomial;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {
        int maxCapacity = 0;
        Polynomial newPolynomial = new Polynomial();

        if(p.vector.length > this.vector.length) {
            maxCapacity = p.vector.length;

            /* ** ** */
            for (int i = 0; i < maxCapacity; i++) {

                if (((Integer) p.vector[i]) != 0)
                    for (int j = 0; j < this.vector.length; j++) {

                        if (((Integer) this.vector[j]) != 0) {

                            if(newPolynomial.vector.length > (i+j) )
                                newPolynomial.setCoefficient(  i + j, ( newPolynomial.vector[i+j] ) + ( (((Integer) this.vector[j])) * ((Integer) p.vector[i]) ) );
                            else
                                newPolynomial.setCoefficient(  i + j,  (((Integer) this.vector[j])) * ((Integer) p.vector[i]) );

                        }
                    }
            }
        } else {
            maxCapacity = this.vector.length;

            /* ** ** */
            for (int i = 0; i < maxCapacity; i++) {

                if (((Integer) this.vector[i]) != 0)
                    for (int j = 0; j < p.vector.length; j++) {

                        if (((Integer) p.vector[j]) != 0) {

                            if(newPolynomial.vector.length > (i+j) )
                                newPolynomial.setCoefficient(  i + j, ( newPolynomial.vector[i+j] ) + ( (((Integer) this.vector[i])) * ((Integer) p.vector[j]) ) );
                            else
                                newPolynomial.setCoefficient( i + j, (((Integer) this.vector[i])) * ((Integer) p.vector[j]) );

                        }
                    }
            }

        }

        /* ** ** */
        return newPolynomial;
    }
}
