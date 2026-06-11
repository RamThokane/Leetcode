class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m=mass;
        for(int num: asteroids){
            if(num>m){
                return false;
            }
            else{
                m+=num;
            }
        }
        return true;

        
    
    }
}