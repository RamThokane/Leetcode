class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long minWorkerTime = workerTimes[0];
        for (int time : workerTimes) {
            minWorkerTime = Math.min(minWorkerTime, time);
        }
        
        long high = minWorkerTime * (long) mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReduce(mountainHeight, workerTimes, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReduce(int targetHeight, int[] workerTimes, long totalTime) {
        long totalReduced = 0;
        for (int w : workerTimes) {
            double val = (double) 2 * totalTime / w;
            long x = (long) ((-1 + Math.sqrt(1 + 4 * val)) / 2);
            totalReduced += x;
            if (totalReduced >= targetHeight) return true;
        }
        return totalReduced >= targetHeight;
    }
}