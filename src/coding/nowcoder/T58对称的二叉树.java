package coding.nowcoder;

/*
 * ��Ŀ���� ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 */
public class T58�ԳƵĶ����� {
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
}
