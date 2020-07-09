int movesToMakeZigzag(int* nums, int numsSize){
    int oddCount = 0; // count the moves to let odd nums become smaller
    int evenCount = 0; // count the moves to let even nums become smaller

    for (int i = 0; i < numsSize; i++) {
        int lcount = 0;
        int rcount = 0;

        // larger than left element
        if (i > 0 && nums[i] - nums[i - 1] >= 0) {
            lcount = nums[i] - nums[i - 1] + 1;
        }

        // larger than right element
        if (i < numsSize - 1 && nums[i] - nums[i + 1] >= 0) {
            rcount = nums[i] - nums[i + 1] + 1;
        }

        // use the max move
        int count = lcount > rcount ? lcount : rcount;

        // odd nums
        if (i % 2 != 0) {
            oddCount += count;
        } else {
            evenCount += count;
        }
    }

    return oddCount < evenCount ? oddCount : evenCount;
}