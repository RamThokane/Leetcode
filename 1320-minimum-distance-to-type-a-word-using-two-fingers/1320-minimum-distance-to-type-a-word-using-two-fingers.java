class Solution {
    public int minimumDistance(String word) {
        int[][] dp = new int[301][27];
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = 4000;
            }
        }
        
        dp[0][26] = 0;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = i > 0 ? word.charAt(i - 1) - 'A' : 26;
            
            for (int other = 0; other < 27; other++) {
                if (dp[i][other] == 4000) continue;
                
                dp[i + 1][other] = Math.min(dp[i + 1][other], dp[i][other] + getDist(prev, curr));
                
                dp[i + 1][prev] = Math.min(dp[i + 1][prev], dp[i][other] + getDist(other, curr));
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        for (int j = 0; j < 27; j++) {
            minDistance = Math.min(minDistance, dp[n][j]);
        }
        return minDistance;
    }

    private int getDist(int from, int to) {
        if (from == 26) return 0;
        int x1 = from / 6, y1 = from % 6;
        int x2 = to / 6, y2 = to % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}