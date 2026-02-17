class Solution {
   
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

    
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

        
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

          
            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

          
            res = Math.max(res, maxProd);
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
    }
}
