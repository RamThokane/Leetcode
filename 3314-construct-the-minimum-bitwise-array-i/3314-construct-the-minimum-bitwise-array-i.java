class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            
            if (val == 2) {
                ans[i] = -1;
            } else {
                
                ans[i] = val - ((~val & (val + 1)) >> 1);
            }
        }

        return ans;
    }
}