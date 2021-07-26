package test;

public class Test {

    public static void main(String[] args) {
        int input[] = {9, 8, 9};
        System.out.println("The sum of all input in array using Recurrsion : " + sum(input));
    }

    public static int sum(int input[]) {

        if(input.length == 1)
            return input[0];

        int subArray[] = new int[input.length-1];
        for(int i=1; i < input.length; i++) {
            subArray[i-1] = input[i];
        }

        int output = input[0] + sum(subArray);

        return output;
    }
}
