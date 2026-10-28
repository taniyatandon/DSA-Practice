class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum=nums[0];
        int maxSum=nums[0];
        int total=nums[0];
        int currMin=nums[0];
        int currMax=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            currMin=Math.min(nums[i],currMin+nums[i]);
            minSum=Math.min(minSum,currMin);
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxSum=Math.max(maxSum,currMax);
        }
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum,total-minSum);
    }
}