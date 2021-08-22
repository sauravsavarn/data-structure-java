////////
THIS PROBLEM IS SOLVED USING BOTH 
    1. RECURSIVE WAY : ref. Solution1
            ----- to try with this approach, call this Class Solution1 inside the Runner.java
    2. RECURSIVE WAY : ref. Solution2 ///////THIS IS MOST OPTIMAL SOLUTION FOR VERY-VERY LARGE INPUT
            ----- to stop using this approach, comment inside the Runner.java and write for Solution1.
            
            
   ----- NOTE: Solution2 & Solution1, they are both Recursive way to solve this problem,
               but Solution2 is the most elegant than Solution1 approach of solving this.
               Solution2 is the Hashing based solution along-with the Recursion.
               
   Solution2 : This is hashing based solution. We traverse binary search tree by 
               inorder way and insert node’s value into a set. Also, check for any node, 
               difference between given sum and node’s value in set, if it is found 
               then pair exists otherwise it doesn’t exist. 
               