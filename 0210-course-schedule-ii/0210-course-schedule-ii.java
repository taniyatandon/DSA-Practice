class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] inorder=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
            inorder[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0)q.add(i);
        }
        int[] ans=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[index++]=node;
            for(int i:adj.get(node)){
                inorder[i]--;
                if(inorder[i]==0)q.add(i);
            }
        }
        if(index != numCourses) return new int[]{};
        return ans;
    }
}