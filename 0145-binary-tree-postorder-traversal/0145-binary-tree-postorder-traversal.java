/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(true){
            while(node!=null){
                st.push(node);
                st.push(node);
                node=node.left;
            }
            if(st.isEmpty()){
                break;
            }
            node=st.pop();
            if(!st.isEmpty() && st.peek()==node){
                node=node.right;
            }else{
                list.add(node.val);
                node=null;
            }
        }
        return list;
    }
   
}