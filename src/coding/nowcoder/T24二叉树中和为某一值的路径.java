package coding.nowcoder;

import java.util.ArrayList;

/*
 * 题目描述 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class T24二叉树中和为某一值的路径 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
			ArrayList<ArrayList<Integer>> des = new ArrayList<ArrayList<Integer>>();
			ThroughPath(root, target, null, des);
			return des;
		}
		public void ThroughPath(TreeNode root, int target, ArrayList<Integer> now, ArrayList<ArrayList<Integer>> des) {
			ArrayList<Integer> list;
			if (now != null)
				list = new ArrayList<Integer>(now);
			else
				list = new ArrayList<Integer>();
			if (root != null) {
				list.add(root.val);
				if (root.val == target && root.left == null && root.right == null) {
					des.add(list);
				} else {
					ThroughPath(root.left, target - root.val, list, des);
					ThroughPath(root.right, target - root.val, list, des);
				}
			}
		}
	}
}
