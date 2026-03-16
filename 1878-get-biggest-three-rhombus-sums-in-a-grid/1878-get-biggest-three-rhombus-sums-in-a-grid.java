import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3) set.pollLast();

                for (int len = 1; ; len++) {
                    int topR = i - len, topC = j;
                    int bottomR = i + len, bottomC = j;
                    int leftR = i, leftC = j - len;
                    int rightR = i, rightC = j + len;

                    if (topR < 0 || bottomR >= m || leftC < 0 || rightC >= n) break;

                    int currentSum = 0;
                    for (int k = 0; k < len; k++) {
                        currentSum += grid[topR + k][topC + k];
                        currentSum += grid[rightR + k][rightC - k];
                        currentSum += grid[bottomR - k][bottomC - k];
                        currentSum += grid[leftR - k][leftC + k];
                    }

                    set.add(currentSum);
                    if (set.size() > 3) set.pollLast();
                }
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            result[idx++] = val;
        }
        return result;
    }
}