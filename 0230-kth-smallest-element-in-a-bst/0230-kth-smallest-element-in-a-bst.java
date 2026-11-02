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
    private int kthSmallest=-1;
    private int counter=0;
    private void findSmallest(TreeNode root,int k){
        if(root==null || counter>=k){
            return;
        }
        findSmallest(root.left,k);
        counter++;
        if(counter==k){
            kthSmallest=root.val;
            return;
        }
        findSmallest(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        findSmallest(root,k);
        return kthSmallest;
    }
}