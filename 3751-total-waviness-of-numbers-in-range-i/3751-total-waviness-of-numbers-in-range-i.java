class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        for (int i = num1; i <= num2; i++) {
            totalSum += getWaviness(i);
        }
        return totalSum;
    }

    private int getWaviness(int n) {
        if (n < 100) {
            return 0;
        }
        
        String s = Integer.toString(n);
        int count = 0;
        int len = s.length();
        
        for (int i = 1; i < len - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                count++;
            }
        }
        return count;
    }
}