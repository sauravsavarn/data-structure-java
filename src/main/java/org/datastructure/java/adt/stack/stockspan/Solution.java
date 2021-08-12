package org.datastructure.java.adt.stack.stockspan;


import java.util.Stack;

public class Solution {

    private static Stack spanStack = new Stack();
    private static int counterStockSpan=0;
    private static int counterStockSpanElement=-1;
    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int[] stockSpan = new int[price.length];
        int startingIndex= price.length;
        boolean statusPush=false;
        for (int i = startingIndex-1; i > -1 ; i--) {
            if(counterStockSpan==0) {
                counterStockSpanElement=price[i];
                counterStockSpan+=1;
                //continue;

                if(startingIndex==1) { /////////check if this is the last element in the array otherwise skip. If found then push that count for the last element into Stack.
                    spanStack.push(counterStockSpan);
                    counterStockSpan=0;
                    statusPush=false;
                }
            } else {
                if(price[i]<counterStockSpanElement) {
                    counterStockSpan+=1;
                    //continue;;
                } else {
                    spanStack.push(counterStockSpan);
                    counterStockSpan=0;
                    statusPush=true;

                    startingIndex-=1;
                    i = startingIndex;
                }

                if(i==0 && startingIndex-1!=0) {
                    startingIndex-=1;
                    i = startingIndex;

                    if(!statusPush) {
                        spanStack.push(counterStockSpan);
                        counterStockSpan=0;
                        statusPush=false;
                    }
                }

                if(statusPush)
                    statusPush=false;
            }
        }

        int index=0;
        while (!spanStack.isEmpty()) {
            stockSpan[index++]=(int)spanStack.pop();
        }

        return stockSpan;
    }

}