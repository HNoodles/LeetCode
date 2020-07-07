# include <vector>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int size1 = nums1.size();
        int size2 = nums2.size();
        int target = (size1 + size2) / 2 + 1;
        int odd = (size1 + size2) % 2;
        int count = 0;

        int one = 0;
        int two = 0;
        double cur, las;

        while (count < target) {
            las = cur;
            if (!(one >= size1) && (two >= size2 || nums1[one] < nums2[two])) {
                cur = nums1[one];
                one++;
            } else {
                cur = nums2[two];
                two++;
            }
            count++;
        }

        if (odd) {
            return cur; 
        } else {
            return (cur + las) / 2;
        }
    }
};