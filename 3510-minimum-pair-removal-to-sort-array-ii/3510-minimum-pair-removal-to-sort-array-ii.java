import java.util.PriorityQueue;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        long[] vals = new long[n];
        int[] next = new int[n];
        int[] prev = new int[n];
        long[] pairSums = new long[n];

        for (int i = 0; i < n; i++) {
            vals[i] = nums[i];
            next[i] = i + 1;
            prev[i] = i - 1;
            pairSums[i] = Long.MIN_VALUE;
        }
        next[n - 1] = -1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int inversions = 0;

        for (int i = 0; i < n - 1; i++) {
            if (vals[i] > vals[i + 1]) {
                inversions++;
            }
            long sum = vals[i] + vals[i + 1];
            pairSums[i] = sum;
            pq.offer(new long[]{sum, i});
        }

        if (inversions == 0) return 0;

        int ops = 0;

        while (inversions > 0 && !pq.isEmpty()) {
            long[] top = pq.poll();
            long s = top[0];
            int i = (int) top[1];

            if (pairSums[i] != s) continue;

            ops++;

            int j = next[i];
            if (j == -1) continue;

            if (prev[i] != -1 && vals[prev[i]] > vals[i]) inversions--;
            if (vals[i] > vals[j]) inversions--;
            if (next[j] != -1 && vals[j] > vals[next[j]]) inversions--;

            vals[i] += vals[j];
            pairSums[j] = Long.MIN_VALUE;

            int nextNode = next[j];
            next[i] = nextNode;
            if (nextNode != -1) {
                prev[nextNode] = i;
            }

            if (prev[i] != -1 && vals[prev[i]] > vals[i]) inversions++;
            if (next[i] != -1 && vals[i] > vals[next[i]]) inversions++;

            if (prev[i] != -1) {
                long newSum = vals[prev[i]] + vals[i];
                pairSums[prev[i]] = newSum;
                pq.offer(new long[]{newSum, prev[i]});
            }

            if (next[i] != -1) {
                long newSum = vals[i] + vals[next[i]];
                pairSums[i] = newSum;
                pq.offer(new long[]{newSum, i});
            } else {
                pairSums[i] = Long.MIN_VALUE;
            }
        }

        return ops;
    }
}
