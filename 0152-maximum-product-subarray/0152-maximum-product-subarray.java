class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int prev=1;
        int end=1;
        int n=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(prev==0)prev=1;
            if(end==0)end=1;
            prev*=nums[i];
            end*=nums[n-i];
            max=Math.max(max,Math.max(prev,end));
        }
        return max;
    }
}