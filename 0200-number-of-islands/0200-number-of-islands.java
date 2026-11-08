class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    // Create queue
                    Queue<int[]>q=new LinkedList<>();
                    // Mark starting cell visited
                    visited[i][j]=true;
                    // Add starting coordinates
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] node = q.poll();
                        int r = node[0];
                        int c = node[1];
                        for(int k=0; k<4; k++){
                            int nr = r + delRow[k];
                            int nc = c + delCol[k];
                            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}