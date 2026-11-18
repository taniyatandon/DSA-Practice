class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean color=true;
        int n=graph.length;
        int m=graph[0].length;
        boolean[] visited=new boolean[n];
        boolean[] colors=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                colors[i]=color;
                while(!q.isEmpty()){
                    int node=q.poll();
                    boolean c=colors[node];
                    int[] adj=graph[node];
                    for(int j=0;j<adj.length;j++){
                        if(!visited[adj[j]]){
                            q.add(adj[j]);
                            colors[adj[j]]=!c;
                            visited[adj[j]]=true;
                        }else{
                            if(colors[adj[j]]==c)return false;
                        }
                    }
                }
            }
        }
        return true;    
    }
}