////////
THIS PROBLEM IS SOLVED USING BOTH 
    1. ITERATIVE WAY (With Dynamic Programing & Memoization): ref. Solution1
            ----- to try with this approach, uncomment Solution1 call inside the Runner.java
    2. RECURSIVE WAY (With Dynamic Programing & Memoization) : ref. Solution2 ///////THIS IS MOST OPTIMAL SOLUTION
            ----- to stop using this approach, comment inside the Runner.java.

   ----- NOTE: Solution2 is the (RECURSIVE + DP & Memoization) WAY of Implementation, to solve this 
               problem, and thus Solution2 are the most elegant way to solve this
               problem than Solution1 approach of solving this. This is because let say for n=10000000, 
               where total num of digits >7, then Solution1 will give error (i.e. not correct output). 
               For n=9999999, where total num of digits >6 will also give error when using Solution1. 
               Also noted for both n=10000000 or n=9999999, output will be same.