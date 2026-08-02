
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

       
        Arrays.sort(nums);

        int max = 1;
        int current = 1;

        
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                
                max = Math.max(max, current);
                current = 1;
            }
        }

        return Math.max(max, current);
    }
}