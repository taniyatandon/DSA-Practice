class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
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
            int i=node[0];
            int j=node[1];
            for(int k=0;k<4;k++){
                int row=i+delrow[k];
                int col=j+delcol[k];
                if(row>=0 && row<n && col>=0 && col<m && !visited[row][col] && board[row][col]=='O'){
                    visited[row][col]=true;
                    q.add(new int[]{row,col});
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}