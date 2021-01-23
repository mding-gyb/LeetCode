import java.util.ArrayList;
import java.util.List;

public class Q98 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		@SuppressWarnings("unused")
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inOrder(root, nums);
        while (nums.size() > 1) {
        	if (nums.get(0) > nums.get(1)) {
        		return false;
        	}
        	nums.remove(0);
        }
        return true;
    }
	
	public void inOrder(TreeNode root, List<Integer> nums) {
		if (root.left != null) {
			inOrder(root.left, nums);
		}
		nums.add(root.val);
		if (root.right != null) {
			inOrder(root.right, nums);
		}
	}
}
