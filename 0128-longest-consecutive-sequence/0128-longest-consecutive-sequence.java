import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        int maxStreak = 1;
        int currentStreak = 1;

        // Step 2: Iterate through the sorted array
        for (int i = 1; i < nums.length; i++) {
            // Ignore duplicate numbers (e.g., [1, 2, 2, 3])
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // If current element is consecutive to the previous one
            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                // Sequence broke, reset current streak count
                maxStreak = Math.max(maxStreak, currentStreak);
                currentStreak = 1;
            }
        }

        return Math.max(maxStreak, currentStreak);
    }
}