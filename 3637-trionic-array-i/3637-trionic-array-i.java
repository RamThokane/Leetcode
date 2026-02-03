class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int p = 0;
        // 1. Find the end of the first strictly increasing segment
        while (p < n - 2 && nums[p] < nums[p + 1]) {
            p++;
        }
        
        // Cannot be trionic if it never increases
        if (p == 0) return false;

        int q = p;
        // 2. Find the end of the strictly decreasing segment (valley)
        while (q < n - 1 && nums[q] > nums[q + 1]) {
            q++;
        }

        // If no decreasing part exists (q=p) or it ends immediately (q=n-1)
        if (q == p || q == n - 1) return false;

        // 3. Check if the rest of the array is strictly increasing
        while (q < n - 1 && nums[q] < nums[q + 1]) {
            q++;
        }

        // Must reach the very last element
        return q == n - 1;
    }
}