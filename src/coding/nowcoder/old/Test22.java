package coding.nowcoder.old;
// 从上往下打印出二叉树的每个节点，同层节点从左至右打印
import java.util.ArrayList;

public class Test22 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public class Solution {
		public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			if (root == null)
				return res;
			ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
			TreeNode index;
			queue.add(root);
			while (!queue.isEmpty()) {
				index = queue.get(0);
				queue.remove(0);
				res.add(index.val);
				if (index.left != null)
					queue.add(index.left);
				if (index.right != null)
					queue.add(index.right);
			}
			return res;

		}
	}
}
