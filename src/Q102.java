import java.util.ArrayList;
import java.util.List;

public class Q102 {
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
	public List<List<Integer>> levelOrder(TreeNode root) {
        int maxDepth = treeDepth(root);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<TreeNode> queue = new ArrayList<TreeNode>();
        if(root == null) {
        	return output;
        }
        queue.add(root);
        for (int i = 0; i < maxDepth; i ++) {
        	List<Integer> levelOutput = new ArrayList<Integer>();
        	List<TreeNode> nextQueue = new ArrayList<TreeNode>();
        	while(!queue.isEmpty()) {
        		if (queue.get(0) != null) {
        			levelOutput.add(queue.get(0).val);
        			nextQueue.add(queue.get(0).left);
        			nextQueue.add(queue.get(0).right);
        			queue.remove(0);
        		} else {
        			queue.remove(0);
        		}
        	}
        	output.add(levelOutput);
        	queue = nextQueue;
        }
        return output;
    }
	private int treeDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(1 + treeDepth(root.left), 1 + treeDepth(root.right));
	}
}
