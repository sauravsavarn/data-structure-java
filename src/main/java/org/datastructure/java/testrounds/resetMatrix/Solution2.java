package org.datastructure.java.testrounds.resetMatrix;

public class Solution2 {
    public static void makeRowsCols0(int [][]input) {
        // Write your code here
       modifyMatrix(input, input.length, input[0].length);
    }

    public static void modifyMatrix(int input[ ][ ], int R, int C)
    {
        int row[ ]= new int [R];
        int col[ ]= new int [C];
        int i, j;

        /* Initialize all values of row[] as 0 */
        for (i = 0; i < R; i++)
        {
            row[i] = 1;
        }


        /* Initialize all values of col[] as 0 */
        for (i = 0; i < C; i++)
        {
            col[i] = 1;
        }


        /* Store the rows and columns to be marked as
        1 in row[] and col[] arrays respectively */
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                if (input[i][j] == 0)
                {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        /* Modify the input matrix mat[] using the
        above constructed row[] and col[] arrays */
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                if ( row[i] == 0 || col[j] == 0 )
                {
                    input[i][j] = 0;
                }
            }
        }
    }

}
