
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            inorder[p[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }

        int cnt=0;

        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;

            for(int j : adj.get(node)){
                inorder[j]--;

                if(inorder[j]==0){
                    q.add(j);
                }
            }
        }

        return cnt==numCourses;
    }
}
