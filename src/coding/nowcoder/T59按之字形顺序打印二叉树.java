package coding.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 题目描述 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class T59按之字形顺序打印二叉树 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			Stack<TreeNode> oddStack = new Stack<TreeNode>();
			oddStack.push(pRoot);
			Stack<TreeNode> evenStack = new Stack<TreeNode>();
			boolean isOdd = true;
			while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
				TreeNode s;
				ArrayList<Integer> t = new ArrayList<Integer>();
				if (isOdd) {
					while (!oddStack.isEmpty()) {
						s = oddStack.pop();
						if (s != null) {
							if (s.left != null)
								evenStack.push(s.left);
							if (s.right != null)
								evenStack.push(s.right);
							t.add(s.val);
						}
					}
					if (!t.isEmpty()) {
						res.add(t);
						isOdd = !isOdd;
					}
				} else {
					while (!evenStack.isEmpty()) {
						s = evenStack.pop();
						if (s != null) {
							if (s.right != null)
								oddStack.push(s.right);
							if (s.left != null)
								oddStack.push(s.left);
							t.add(s.val);
						}
					}
					if (!t.isEmpty()) {
						res.add(t);
						isOdd = !isOdd;
					}
				}
			}
			return res;
		}
	}
}
