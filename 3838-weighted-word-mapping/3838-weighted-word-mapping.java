class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] result = new char[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int weightSum = 0;
            
            for (int j = 0; j < word.length(); j++) {
                weightSum += weights[word.charAt(j) - 'a'];
            }
            
            int rem = weightSum % 26;
            result[i] = (char) ('z' - rem);
        }
        
        return new String(result);
    }
}