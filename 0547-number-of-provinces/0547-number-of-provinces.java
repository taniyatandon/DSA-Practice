class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                visited[i]=true;
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int j = 0; j < isConnected.length; j++){
                        if(isConnected[node][j] == 1 && !visited[j]){
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}