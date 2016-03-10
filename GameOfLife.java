//https://leetcode.com/problems/game-of-life/

public class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int ones = 0;
                for (int p = (i-1)>=0?i-1:0; p <= i+1 && p<rows; p++) {
                    for (int q = (j-1)>=0?j-1:0; q <= j + 1 && q<cols; q++) {
                        if (p == i && q == j)
                            continue;
                        if (board[p][q] == 1)
                            ones++;
                    }
                }
                if (board[i][j] == 0) {
                    if (ones == 3)
                        result[i][j] = 1;
                    else
                        result[i][j] = 0;
                } else {
                    if (ones == 3 || ones == 2)
                        result[i][j] = 1;
                    else
                        result[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            System.arraycopy(result[i], 0, board[i], 0, cols);
        }
    }
}
