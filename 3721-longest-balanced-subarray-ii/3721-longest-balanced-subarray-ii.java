import java.util.*;

public class Solution {
    private int[] mn;
    private int[] mx;
    private int[] lazy;

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        // Segment tree size: 4 * n
        mn = new int[4 * n];
        mx = new int[4 * n];
        lazy = new int[4 * n];

        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastPos[val];
            // Even adds 1 to the difference, Odd subtracts 1 (-1)
            int diff = (val % 2 == 0) ? 1 : -1;

            // Update range [prev + 1, i] in the segment tree
            update(1, 0, n - 1, prev + 1, i, diff);
            lastPos[val] = i;

            // Find the first index j such that prefix difference is 0
            int start = findFirst(1, 0, n - 1, i);
            if (start != -1) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }

        return maxLen;
    }

    private void push(int node) {
        if (lazy[node] != 0) {
            int val = lazy[node];
            
            // Apply lazy value to children
            mn[2 * node] += val;
            mx[2 * node] += val;
            lazy[2 * node] += val;

            mn[2 * node + 1] += val;
            mx[2 * node + 1] += val;
            lazy[2 * node + 1] += val;

            lazy[node] = 0;
        }
    }

    private void update(int node, int segLeft, int segRight, int queryLeft, int queryRight, int addValue) {
        if (queryLeft > queryRight) return;

        if (queryLeft == segLeft && queryRight == segRight) {
            mn[node] += addValue;
            mx[node] += addValue;
            lazy[node] += addValue;
        } else {
            push(node);
            int mid = (segLeft + segRight) / 2;
            update(2 * node, segLeft, mid, queryLeft, Math.min(queryRight, mid), addValue);
            update(2 * node + 1, mid + 1, segRight, Math.max(queryLeft, mid + 1), queryRight, addValue);
            
            mn[node] = Math.min(mn[2 * node], mn[2 * node + 1]);
            mx[node] = Math.max(mx[2 * node], mx[2 * node + 1]);
        }
    }

    private int findFirst(int node, int segLeft, int segRight, int limit) {
        // Pruning: if current range is beyond limit or 0 is not in [min, max]
        if (segLeft > limit || mn[node] > 0 || mx[node] < 0) {
            return -1;
        }
        if (segLeft == segRight) {
            return segLeft;
        }

        push(node);
        int mid = (segLeft + segRight) / 2;
        
        // Try left child first for the "longest" subarray (smallest start index)
        int res = findFirst(2 * node, segLeft, mid, limit);
        if (res == -1 && mid < limit) {
            res = findFirst(2 * node + 1, mid + 1, segRight, limit);
        }
        return res;
    }
}