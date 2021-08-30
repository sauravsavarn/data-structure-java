////////
THIS PROBLEM IS SOLVED USING BOTH 
    1. ITERATIVE + RECURSIVE WAY : ref. Solution1
            ----- to try with this approach, call this Class Solution1 inside the Runner.java
            ----- HERE: Recursion is used to find the MIN-HEAP & Kth Largest Element
    2. ITERATIVE WAY : ref. Solution2 ///////THIS IS MOST OPTIMAL SOLUTION
            ----- to stop using this approach, comment inside the Runner.java and write for Solution1.
            ----- HERE: No Recursion is used to get the Kth Largest ELement. Instead used the 
                  java.util.PriorityQueue Datastructure to maintain the highest order Priority. This
                  is used to get the Kth Largest Element.
            
   ----- NOTE: Solution2 is the ITERATIVE-WAY & Solution1 is combination of ITERATIVE & RECURSIVE WAY
               of Implementation, to solve this problem,
               but Solution2 is the most elegant than Solution1 approach of solving this.
               In Solution2, we are using PriorityQueue to find the Kth Largest Element,
               instead of manually finding KthLargestElement function as in Solution1