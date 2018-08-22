package coding.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 题目描述 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class T22从上往下打印二叉树 {
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
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			TreeNode index;
			queue.add(root);
			while (!queue.isEmpty()) {
				index = queue.poll();
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
