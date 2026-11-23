class Solution {
    public int longestOnes(int[] nums, int k) {
        int lft=0;
        int maxLength=0;
        int zeroes=0;
        for(int rt=0;rt<nums.length;rt++){
            if(nums[rt]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[lft]==0){
                    zeroes--;
                }
                lft++;
            }
            maxLength=Math.max(maxLength,rt-lft+1);
        }
        return maxLength;
    }
}