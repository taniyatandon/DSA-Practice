
class Solution {
    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] pathVis, boolean[] check) {
        visited[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int i : graph[node]) {
            if(!visited[i]) {
                if(dfs(i, graph, visited, pathVis, check)) return true;
            } 
            else if(pathVis[i]) {
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, graph, visited, pathVis, check);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(check[i]) ans.add(i);
        }

        return ans;
    }
}
