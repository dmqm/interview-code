package coding.nowcoder.old;

/*
 * 题目描述 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
import java.util.Stack;

public class Test59 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		boolean isSymmetrical(TreeNode pRoot) {
			if (pRoot == null)
				return true;
			return isEqual(pRoot.left, pRoot.right);
		}

		boolean isEqual(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			return isEqual(left.left, right.right) && isEqual(left.right, right.left);
		}
	}
	public class Solution2 {
		boolean isSymmetrical(TreeNode pRoot) {
			if (pRoot == null || (pRoot.left == null && pRoot.right == null))
				return true;
			if (pRoot.left == null || pRoot.right == null)
				return false;
			Stack<TreeNode> s = new Stack<TreeNode>();
			s.push(pRoot.left);
			s.push(pRoot.right);
			TreeNode leftIndex, rightIndex;
			while (!s.isEmpty()) {
				rightIndex = s.pop();
				leftIndex = s.pop();
				if (rightIndex.val != leftIndex.val)
					return false;
				if (rightIndex.right != null && leftIndex.left != null) {
					s.push(leftIndex.left);
					s.push(rightIndex.right);
				} else if (rightIndex.right != null || leftIndex.left != null)
					return false;
				if (leftIndex.right != null && rightIndex.left != null) {
					s.push(leftIndex.right);
					s.push(rightIndex.left);
				} else if (leftIndex.right != null || rightIndex.left != null)
					return false;
			}
			return s.isEmpty();
		}
	}
}
