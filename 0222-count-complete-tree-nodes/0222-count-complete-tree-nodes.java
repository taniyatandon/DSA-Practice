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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int left=heightLeft(root);
        int right=heightRight(root);
        if(left==right)return (2<<(left))-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int heightLeft(TreeNode root){
        int count=0;
        if(root==null){
            return count;
        }
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    private int heightRight(TreeNode root){
        int count=0;
        if(root==null){
            return count;
        }
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
}