class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;

        // binary search
        while (left <= right) {            
            // target is mid
            if (nums[mid] == target) {
                return mid;
            }

            // one of the subsequence must be sorted, 
            // if one subsequence is sorted, its left must be less than its right
            // otherwise, it's not sorted
            if (nums[left] <= nums[mid]) {
                // left sequence is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // target is in the left sequence(sorted)
                    right = mid - 1;
                } else {
                    // target is in the right sequence(unsorted)
                    left = mid + 1;
                }
            } else {
                // right sequence is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // target is in the right sequence(sorted)
                    left = mid + 1;
                } else {
                    // target is in the left sequence(unsorted)
                    right = mid - 1;
                }
            }

            mid = (left + right) / 2;
        }

        return -1;
    }
}