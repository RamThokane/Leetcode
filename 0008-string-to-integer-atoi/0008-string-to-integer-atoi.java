class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        
        if (index == n) {
            return 0;
        }

       
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

       
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

         
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}