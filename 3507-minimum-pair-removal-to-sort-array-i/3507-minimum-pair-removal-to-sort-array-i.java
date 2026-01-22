import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Long> list = new ArrayList<>();
        for (int num : nums) list.add((long) num);
        int ans = 0;
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;

            long minSum = Long.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                long sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            list.set(idx, minSum);
            list.remove(idx + 1);
            ans++;
        }
        return ans;
    }
}