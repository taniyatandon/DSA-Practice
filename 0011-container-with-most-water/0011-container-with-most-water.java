class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int max=0;
        int end=height.length-1;
        while(start<end){
            int h= Math.min(height[start],height[end]);
            int width=end-start;
            max=Math.max(max,h*width);
            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        
        return max;
    }
}