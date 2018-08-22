package coding.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Ŀ���� ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class T38����������� {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public int TreeDepth(TreeNode pRoot) {
			if (pRoot == null) {
				return 0;
			}
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(pRoot);
			int depth = 0, count = 0, nextCount = 1;
			while (queue.size() != 0) {
				TreeNode top = queue.poll();
				count++;
				if (top.left != null) {
					queue.add(top.left);
				}
				if (top.right != null) {
					queue.add(top.right);
				}
				if (count == nextCount) {
					nextCount = queue.size();
					count = 0;
					depth++;
				}
			}
			return depth;
		}
	}
	public class Solution2 {
		public int TreeDepth(TreeNode root) {
			if (root != null) {
				int leftD = TreeDepth(root.left) + 1;
				int rightD = TreeDepth(root.right) + 1;
				return leftD > rightD ? leftD : rightD;
			} else {
				return 0;
			}
		}
	}
}
