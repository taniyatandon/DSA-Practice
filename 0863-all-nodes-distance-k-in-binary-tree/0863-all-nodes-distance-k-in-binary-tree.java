/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> mp){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                mp.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                mp.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentmp=new HashMap<>();
        markParents(root,parentmp);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        visited.put(target,true);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        int level=0;
        while(!q.isEmpty()){
            if(level==k)break;
            level++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parentmp.get(node)!=null && visited.get(parentmp.get(node))==null){
                    q.offer(parentmp.get(node));
                    visited.put(parentmp.get(node),true);
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}