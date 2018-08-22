package coding.nowcoder.old;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Ŀ���� ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 */
public class Test61 {


	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public class Solution {
		ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			if (pRoot == null)
				return res;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(pRoot);
			ArrayList<Integer> l = new ArrayList<Integer>();
			TreeNode t;
			int count = 0, sum = 1;
			while (!queue.isEmpty()) {
				t = queue.poll();
				l.add(t.val);
				if (t.left != null)
					queue.add(t.left);
				if (t.right != null)
					queue.add(t.right);
				if (++count == sum) {
					ArrayList<Integer> nl = new ArrayList<Integer>(l);
					l.clear();
					res.add(nl);
					count = 0;
					sum = queue.size();
				}
			}
			return res; 
		}

	}
}
