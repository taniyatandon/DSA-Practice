class Solution {
    public int trap(int[] height) {
        int rightMax=height[height.length-1];
        int leftMax=height[0];
        int right=height.length-1;
        int left=0;
        int ans=0;
        while(left<right){
            if (height[left] <= height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }
                ans+=leftMax-height[left++];
            }else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }
                ans+=rightMax-height[right--];
            }
        }
        return ans;
    }
}