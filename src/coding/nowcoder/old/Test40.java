package coding.nowcoder.old;
// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
public class Test40 {
	public class Solution {
		public boolean IsBalanced_Solution(TreeNode root) {
			if(root==null)
				return true;
			if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
				return false;
			return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
		}

		public int TreeDepth(TreeNode root) {
			if (root != null) {
				int leftD = TreeDepth(root.left) + 1;
				int rightD = TreeDepth(root.right) + 1;
				return leftD > rightD ? leftD : rightD;
			} else {
				return 0;
			}
		}
	}
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}


}
