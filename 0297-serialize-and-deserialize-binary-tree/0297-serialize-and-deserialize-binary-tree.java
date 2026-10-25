/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().equals("null") || data.trim().isEmpty()) {
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String[] str=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        int i=1;
        while (!q.isEmpty() && i < str.length) {
            TreeNode node = q.poll();
            if (!str[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                node.left = left;
                q.offer(left);
            }
            i++;

            if (i < str.length && !str[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                node.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));