package coding.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Ŀ���� �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 */
public class T22�������´�ӡ������ {
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
