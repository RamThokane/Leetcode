class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int x = calc(landStartTime, landDuration, waterStartTime, waterDuration);
        int y = calc(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(x, y);
    }

    private int calc(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int minFinish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minFinish1 = Math.min(minFinish1, start1[i] + duration1[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < start2.length; j++) {
            int currentFinish = Math.max(minFinish1, start2[j]) + duration2[j];
            ans = Math.min(ans, currentFinish);
        }
        return ans;
    }
}