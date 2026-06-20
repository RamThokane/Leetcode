import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        char[] result = new char[len];
        int idx = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (stack.size() > 0) {
                    result[idx] = c;
                    idx = idx + 1;
                }
                stack.push(c);
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    result[idx] = c;
                    idx = idx + 1;
                }
            }
        }
        
        return new String(result, 0, idx);
    }
}