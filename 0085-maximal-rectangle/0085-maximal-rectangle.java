class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[] heights=new int[n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }else{
                    heights[j]=0;
                }
            }
            maxArea=Math.max(maxArea,maximumArea(heights));
        }
        return maxArea;
    }
    private int maximumArea(int[] heights){
        int n=heights.length;
        Stack<Integer> st= new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int currHt=i==n?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=currHt){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                int area=height*width;
                maxArea=Math.max(area,maxArea);
            }
            if(i<n){
                st.push(i);
            }
        }
        return maxArea;
    }
}