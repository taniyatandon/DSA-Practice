class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int currHeight=i==n?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=currHeight){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                int area=height*width;
                maxArea=Math.max(maxArea,area);
            }
            if(i<n){
                st.push(i);
            }
        }
        return maxArea;
    }
}