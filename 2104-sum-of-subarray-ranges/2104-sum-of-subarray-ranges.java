class Solution {
    public long subArrayRanges(int[] nums) {
        return solve(nums, 0, 0, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private long solve(int[] nums, int i, int end, long min, long max) {
        if (i == nums.length) {
            return 0;
        }

        if (end == nums.length) {
            return solve(nums, i + 1, i + 1, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        min = Math.min(min, nums[end]);
        max = Math.max(max, nums[end]);

        return (max - min) + solve(nums, i, end + 1, min, max);
    }
}