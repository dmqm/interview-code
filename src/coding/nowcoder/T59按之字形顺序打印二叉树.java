package coding.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/*
 * ��Ŀ���� ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class T59��֮����˳���ӡ������ {
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
