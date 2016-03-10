// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length==0)
            return 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] maxSteps = new int[rows][columns];
        
        int max = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(maxSteps[i][j] == 0) {
                    movePath(matrix, maxSteps, i, j, rows, columns);
                    max = Math.max(max, maxSteps[i][j]);
                }
            }
        }
        return max;
    }

    private int movePath(int[][] matrix, int[][] maxSteps, int curRow, int curCol, int maxRows, int maxCols) {
        int steps = 1;
        for(int x : new int[]{-1,1}){
            if(curRow+x>-1 && curRow+x<maxRows && matrix[curRow+x][curCol]>matrix[curRow][curCol]){
                if(maxSteps[curRow+x][curCol]!=0)
                    steps = Math.max(steps, maxSteps[curRow+x][curCol]+1);
                else
                    steps = Math.max(steps, movePath(matrix, maxSteps, curRow+x, curCol, maxRows, maxCols)+1);
            }
            if(curCol+x>-1 && curCol+x<maxCols && matrix[curRow][curCol+x]>matrix[curRow][curCol]){
                if(maxSteps[curRow][curCol+x]!=0)
                    steps = Math.max(steps, maxSteps[curRow][curCol+x]+1);
                else
                    steps = Math.max(steps, movePath(matrix, maxSteps, curRow, curCol+x, maxRows, maxCols)+1);
            }
        }
        maxSteps[curRow][curCol] = steps;
        return steps;
    }
}
