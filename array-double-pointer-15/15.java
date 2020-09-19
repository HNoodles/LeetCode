import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        int n = nums.length;

        // sort the nums first
        Arrays.sort(nums);

        // go through each element of nums to construct the answer
        for (int i = 0; i < n; i++) {
            // skip identical elements to avoid duplicate answers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // use two pointers to check the elements after the i-th element
            // one goes from beginning to end, another goes reversely
            // the loop stops when j and k meet
            for (int j = i + 1; j < n; j++) {
                // skip identical elements to avoid duplicate answers
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = n - 1;

                // find a k from the end to j, to let the sum become 0
                while (j < k && nums[j] + nums[k] + nums[i] > 0) {
                    --k;
                }
        
                // if j = k, as j grows, there will never be a k that would fulfill the requirement
                // because k will not be smaller than j, the sum would only grow bigger
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return answers;
    }
}