package coding.nowcoder;

/*
 * 题目描述 给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class T62二叉搜索树的第K个节点 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		int count = 0;

		TreeNode KthNode(TreeNode pRoot, int k) {
			if (pRoot == null || count > k)
				return null;
			TreeNode res = KthNode(pRoot.left, k);
			if (res != null)
				return res;
			if (++count == k)
				return pRoot;
			res = KthNode(pRoot.right, k);
			if (res != null)
				return res;
			return null;
		}
	}
}
