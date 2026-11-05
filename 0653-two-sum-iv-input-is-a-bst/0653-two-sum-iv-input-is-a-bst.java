class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);

            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public int next() {
        TreeNode node = st.pop();

        if (reverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator leftIter = new BSTIterator(root, false);
        BSTIterator rightIter = new BSTIterator(root, true);

        int i = leftIter.next();
        int j = rightIter.next();

        while (i < j) {
            long sum = (long) i + j;

            if (sum == k) {
                return true;
            } 
            else if (sum < k) {
                if (leftIter.hasNext()) {
                    i = leftIter.next();
                } else {
                    break;
                }
            } 
            else {
                if (rightIter.hasNext()) {
                    j = rightIter.next();
                } else {
                    break;
                }
            }
        }

        return false;
    }
}