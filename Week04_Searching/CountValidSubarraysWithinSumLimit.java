// Counts subarrays with sum <= limit.
// Assumes all numbers are non-negative.
public class CountValidSubarraysWithinSumLimit {
    public static long countSubarrays(int[] nums, int limit) {
        long count = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum > limit) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 1, 1}, 3));
    }
}
