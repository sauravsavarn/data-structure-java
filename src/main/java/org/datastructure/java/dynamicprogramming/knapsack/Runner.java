package org.datastructure.java.dynamicprogramming.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Input {
    private int n;
    private int[] weights;
    private int[] values;
    private int maxWeight;

    public Input(int[] weights, int[] values, int n, int maxWeight) {
        this.n = n;
        this.weights = weights;
        this.values = values;
        this.maxWeight = maxWeight;
    }

    public int getSize() {
        return this.n;
    }

    public int[] getWeights() {
        return this.weights;
    }

    public int[] getValues() {
        return this.values;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }
}

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return (new Input(new int[0], new int[0], 0, 0));
        }

        String[] strWeights = br.readLine().trim().split(" ");
        String[] strValues = br.readLine().trim().split(" ");
        int maxWeight = Integer.parseInt(br.readLine().trim());

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(strWeights[i]);
            values[i] = Integer.parseInt(strValues[i]);
        }

        return (new Input(weights, values, n, maxWeight));

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Input input = takeInput();

        int n = input.getSize();
        int[] weights = input.getWeights();
        int[] values = input.getValues();
        int maxWeight = input.getMaxWeight();


        System.out.println(Solution.knapsack(weights, values, n, maxWeight));
    }
}