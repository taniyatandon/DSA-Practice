class Solution {
    public int maxSubArray(int[] nums) {
       int largestSum=Integer.MIN_VALUE;
       int start=0;
       int sum=0;
       for(int end=0;end<nums.length;end++){
            
            sum+=nums[end];
            
            largestSum=Math.max(sum,largestSum);
            if(sum<0){
                sum=0;
            }
       }
       return largestSum;
    }
}