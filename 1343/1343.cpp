#include <vector>

using namespace std;

class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int sumThres = k * threshold;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int differentSubArr = arr.size() - k + 1;
        for (int i = 0; i < differentSubArr - 1; i++) {
            if (sum >= sumThres) {
                count++;
            }
            sum = sum - arr[i] + arr[i + k];
        }

        if (sum >= sumThres) {
            count++;
        }

        return count;
    }
};