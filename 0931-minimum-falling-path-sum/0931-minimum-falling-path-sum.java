class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Create a copy of the matrix to store intermediate results
        int[][] dp = new int[n][n];
        
        // Copy the first row from the original matrix to the dp matrix
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // Iterate through the matrix starting from the second row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate the minimum falling path sum for the current cell
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE, j <                 n - 1 ? dp[i-1][j+1] : Integer.MAX_VALUE));
            }
        }

        // Find the minimum falling path sum in the last row of the dp matrix
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[n-1][i]);
        }

        return minSum;
    }
}
