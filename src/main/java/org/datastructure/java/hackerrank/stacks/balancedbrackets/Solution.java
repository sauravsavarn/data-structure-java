package org.datastructure.java.hackerrank.stacks.balancedbrackets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    private static Stack stack = new Stack();

    public static String isBalanced(String s) {
        // Write your code here
        String isBalanced = "YES";
        for (int i = 0; i < s.length(); i++) {
            /////get first char from string
            char character = s.charAt(i);

            if (character == '(' || character == '{' || character == '[') stack.push(character);
            else {
                char tempCharacter;
                if (character == ')')
                    tempCharacter = '(';
                else if (character == '}')
                    tempCharacter = '{';
                else tempCharacter = '[';

                ///////now finally look for the matched character in the the Stack, if exists then pop if not found then break the loop chain and return 'NO' othwerwise 'YES'.
                if (stack.isEmpty() || tempCharacter != (char)stack.peek()){
                    isBalanced="NO";
                    break;///break from the loop as no need to continue further.
                }

                stack.pop();
            }
        }

        return isBalanced;
    }
}

public class Solution {
    static String OUTPUT_PATH="C://workspace//workspace_practice//datastructure-practice-java";
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
