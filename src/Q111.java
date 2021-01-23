

public class Q111 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
        if(root.left == null && root.right == null) {
        	return 1;
        }
        if (root.left == null) {
        	return 1 + minDepth(root.right);
        } else if (root.right == null) {
        	return 1 + minDepth(root.left);
        }
        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }
}
