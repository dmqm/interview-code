package coding.nowcoder.old;
// 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class Test17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public class Solution {
		public boolean HasSubtree(TreeNode root1, TreeNode root2) {
			if (root1 == null || root2 == null)
				return false;
			if (IsEqual(root1, root2))
				return true;
			return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
		}

		public boolean IsEqual(TreeNode root1, TreeNode root2) {
			if (root2 == null)
				return true;
			if (root1 == null)
				return false;
			if (root1.val == root2.val)
				return IsEqual(root1.left, root2.left) && IsEqual(root1.right, root2.right);
			return false;
		}
	}

}
