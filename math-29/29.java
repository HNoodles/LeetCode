class Solution {
    public int divide(int dividend, int divisor) {
        // judge if the result is negative
        boolean isNeg = dividend == 0 ? false : (dividend > 0) ^ (divisor > 0);

        long result = 0;
        int power = 1;
        long first = Math.abs((long)dividend);
        long second = Math.abs((long)divisor);
        long ori_second = second;

        while (first >= second) {
            // overflow
            if (isNeg && result >= (long)Integer.MAX_VALUE + 1) {
                break;
            } else if (!isNeg && result >= (long)Integer.MAX_VALUE) {
                break;
            }
            first -= second;
            result += power;

            // add up the divisor
            power++;
            second += ori_second;
        }

        // deal with the remaining part
        while (first >= ori_second) {
            // overflow
            if (isNeg && result >= (long)Integer.MAX_VALUE + 1) {
                break;
            } else if (!isNeg && result >= (long)Integer.MAX_VALUE) {
                break;
            }
            first -= ori_second;
            result++;
        }

        return isNeg ? (int)-result : (int)result;
    }
}