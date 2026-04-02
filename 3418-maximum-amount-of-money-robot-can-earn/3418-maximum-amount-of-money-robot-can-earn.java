class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            int val = coins[0][0];
            if (k > 0 && val < 0) {
                dp[0][0][k] = Math.max(dp[0][0][k], 0);
            }
            if (k == 0 || val >= 0) {
                dp[0][0][k] = Math.max(dp[0][0][k], val);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    int[] dr = {0, 1};
                    int[] dc = {1, 0};

                    for (int d = 0; d < 2; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni < m && nj < n) {
                            int nextVal = coins[ni][nj];
                            
                            dp[ni][nj][k] = Math.max(dp[ni][nj][k], dp[i][j][k] + nextVal);

                            if (k < 2 && nextVal < 0) {
                                dp[ni][nj][k + 1] = Math.max(dp[ni][nj][k + 1], dp[i][j][k]);
                            }
                        }
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}