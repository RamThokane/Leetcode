class Solution {

    // Check if we can make m bouquets on given day
    public boolean isPossible(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {

                count++;

                if (count == k) {
                    bouquets++;
                    count = 0;
                }

            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        // Not enough flowers
        if ((long)m * k > bloomDay.length)
            return -1;

        int minDay = bloomDay[0];
        int maxDay = bloomDay[0];

        // Find minimum and maximum day
        for (int i = 1; i < bloomDay.length; i++) {

            if (bloomDay[i] < minDay)
                minDay = bloomDay[i];

            if (bloomDay[i] > maxDay)
                maxDay = bloomDay[i];
        }

        int low = minDay;
        int high = maxDay;
        int answer = -1;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, mid, m, k)) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return answer;
    }
}