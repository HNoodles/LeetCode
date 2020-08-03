class Solution {
    public int myAtoi(String str) {
        int result = 0;
        boolean isNeg = false;

        // boolean to indicate if is finding the first digit
        boolean isFirst = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c <= '9' && c >= '0') {
                isFirst = false;
                int cValue = Character.getNumericValue(c);

                // check if result is too large for an integer to store
                if (!isNeg) {
                    double threshold = (Integer.MAX_VALUE - cValue) / 10.0;
                    if (result >= threshold) {
                        result = Integer.MAX_VALUE;
                        break;
                    }
                } else {
                    double threshold = (Integer.MIN_VALUE + cValue) / 10.0;
                    if (result <= threshold) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                }
                
                result *= 10;
                if (isNeg) {
                    result -= cValue;
                } else {
                    result += cValue;
                }
            } else if (isFirst && (c == '-' || c == '+')) {
                // is finding the first digit
                if (c == '-') {
                    isNeg = true;
                }
                isFirst = false;
            } else if (!isFirst || c != ' ') {
                // break if: 
                // 1. is finding first digit, but char other than digits and space occurred
                // 2. not finding first digit, but char other than digits occurred
                break;
            }
        }

        return result;
    }
}