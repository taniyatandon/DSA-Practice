class Pair{
    int node;
    boolean color;
    public Pair(int node,boolean color){
        this.node=node;
        this.color=color;
    }
}
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
                Queue<Pair> q=new LinkedList<>();
                q.add(new Pair(i,color));
                colors[i]=color;
                while(!q.isEmpty()){
                    Pair p=q.poll();
                    int node=p.node;
                    boolean c=p.color;
                    int[] adj=graph[node];
                    for(int j=0;j<adj.length;j++){
                        if(!visited[adj[j]]){
                            q.add(new Pair(adj[j],!c));
                            colors[adj[j]]=!c;
                            visited[adj[j]]=true;
                        }else{
                            if(colors[adj[j]]==p.color)return false;
                        }
                    }
                }
            }
        }
        return true;    
    }
}