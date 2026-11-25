
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        int total = (m + n) / 2;
        int idx = 0;

        int prev = 0;
        int curr = 0;

        while(idx <= total) {
            prev = curr;

            if(i < n && (j >= m || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            }
            else {
                curr = nums2[j];
                j++;
            }

            idx++;
        }

        if((n + m) % 2 != 0) {
            return curr;
        }

        return ((double)prev + curr) / 2;
    }
}
