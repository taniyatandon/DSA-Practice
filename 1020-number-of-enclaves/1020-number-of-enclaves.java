class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        visited[i][j]=true;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        int[] delrow=new int[]{-1,0,1,0};
        int[] delcol=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int i=0;i<4;i++){
                int row=node[0]+delrow[i];
                int col=node[1]+delcol[i];
                if(row>=0 && row<=n-1 && col>=0 && col<=m-1 && !visited[row][col] && grid[row][col]==1){
                    q.add(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(!visited[i][j])count++;
                }
            }
        }
        return count;
    }
}