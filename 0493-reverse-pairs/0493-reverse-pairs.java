
class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = mergeSort(nums, temp, low, mid);
        count += mergeSort(nums, temp, mid + 1, high);

        int right = mid + 1;

        for (int left = low; left <= mid; left++) {
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int x = low; x <= high; x++) {
            nums[x] = temp[x];
        }

        return count;
    }
}
