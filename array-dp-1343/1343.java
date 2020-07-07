class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0; // sliding window sum
        int sumThres = threshold * k; // threshold sum

        // sum up first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // # of sub arrays
        int differentSubArrs = arr.length - k + 1;

        // slide the window from 0 to # - 1
        for (int i = 0; i < differentSubArrs - 1; i++) {
            // compare and count
            if (sum >= sumThres) {
                count++;
            }
            // delete first element in sub array, add next element
            sum = sum - arr[i] + arr[i + k];
        }

        // compare the last sub array
        if (sum >= sumThres) {
            count++;
        }
        
        return count;
    }
}