public class MinimumSubarrayTargetSum {
    // Assumes all numbers are positive.
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
