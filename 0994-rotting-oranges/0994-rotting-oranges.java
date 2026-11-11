class Solution {
    public int orangesRotting(int[][] grid) {
        int[] delrows=new int[]{-1,0,1,0};
        int[] delcols=new int[]{0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];
            int time=node[2];
            ans=time;
            for(int i=0;i<4;i++){
                int nr=row+delrows[i];
                int nc=col+delcols[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && grid[nr][nc]==1){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc,time+1});
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}