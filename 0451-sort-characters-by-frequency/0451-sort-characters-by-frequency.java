class Solution {
    public String frequencySort(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            if (counts[i] > 0) {
                int freq = counts[i];
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add((char) i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int freq = buckets.length - 1; freq > 0; freq--) {
            if (buckets[freq] != null) {
                for (char c : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}