class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        char[] result = new char[len];
        int idx = 0;
        int opened = 0;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (opened > 0) {
                    result[idx++] = c;
                }
                opened++;
            } else {
                opened--;
                if (opened > 0) {
                    result[idx++] = c;
                }
            }
        }
        
        return new String(result, 0, idx);
    }
}