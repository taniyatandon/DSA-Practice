class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][] ans=new int[n][m];
        for(int[] row : ans){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    q.add(new int[]{i,j,0});
                    ans[i][j]=0;
                }
            }
        }
        int[] delrow=new int[]{-1,0,1,0};
        int[] delcol=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            int[] node=q.poll();
            int i=node[0];
            int j=node[1];
            int val=node[2];
            for(int k=0;k<4;k++){
                int row=i+delrow[k];
                int col=j+delcol[k];
                if(row>=0 && row<n && col>=0 && col<m && ans[row][col] == -1){
                    q.add(new int[]{row,col,val+1});
                    ans[row][col]=val+1;
                }
            }
        }
        return ans;
    }
}