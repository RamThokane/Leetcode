class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxpile=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>maxpile){
                maxpile=piles[i];
            }
        }

        int low=1;
        int high=maxpile;
        int ans=maxpile;
        while(low<=high){
            int mid=(low+high)/2;
            long totalhrs=0;
            for(int banana:piles){
                 totalhrs += (int) Math.ceil((double) banana / mid);
            }

            if(totalhrs<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;

    

        

    }
}