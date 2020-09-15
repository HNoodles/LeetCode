class Solution {
    public int maxDistance(int[] position, int m) {
        // sort the array to find the min and max pos
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int mid = (left + right) / 2;

        int answer = -1;

        // binary search
        while (left <= right) {
            if (check(position, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

        return answer;
    }

    // check if the array can hold m balls given the minimum distance mid
    private boolean check(int[] position, int m, int mid) {
        int count = 1;
        int index = 0;
        int last = position[index];

        // go through the array to check if m balls can be 
        // put into the array given the minimum distance mid
        for (index = 1; index < position.length; index++) {
            if (position[index] - last >= mid) {
                // put a ball
                last = position[index];
                count++;
            }
            if (count >= m) {
                break;
            }
        }

        return count >= m;
    }
}