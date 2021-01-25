import java.util.List;
import java.util.ArrayList;

public class Q101 {
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
	
	public static boolean isSymmetric(TreeNode root) {
        return symmetricHelp(root, root);
    }
	
	public static boolean symmetricHelp(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null && node2 != null || node1 != null && node2 == null) {
			return false;
		}
		return node1.val == node2.val && symmetricHelp(node1.left, node2.right) && symmetricHelp(node1.right, node2.left);
	}
	
	public static void main(String[]args) {
		TreeNode one = new TreeNode(1);
		TreeNode two_1 = new TreeNode(2);
		TreeNode two_2 = new TreeNode(2);
		TreeNode three_1 = new TreeNode(3);
		TreeNode three_2 = new TreeNode(3);
		TreeNode four_1 = new TreeNode(4);
		TreeNode four_2 = new TreeNode(4);
		one.left = two_1;
		one.right = two_2;
		two_1.left = three_1;
		two_1.right = four_1;
		two_2.left = four_2;
		two_2.right = three_1;
		System.out.println(isSymmetric(one));
	}
}
