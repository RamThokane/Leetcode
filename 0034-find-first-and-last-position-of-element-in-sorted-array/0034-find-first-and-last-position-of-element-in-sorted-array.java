class Solution {
    public int[] searchRange(int[] nums, int target) {
      int n=nums.length;
      int []ans={-1,-1};
      int l=0,h=n-1;
      while(l<=h){
        int m=(l+h)/2;
        if(nums[m]==target){
            ans[0]=m;
            h=m-1;
        }
        else if(nums[m]<target) l=m+1;
        else h=m-1;
}

    l=0;
    h=n-1;
      while(l<=h){
        int m=(l+h)/2;
        if(nums[m]==target){
            ans[1]=m;
            l=m+1;
        }
        else if(nums[m]<target)l=m+1;
        else h=m-1;

      }
        return ans;
    }
}