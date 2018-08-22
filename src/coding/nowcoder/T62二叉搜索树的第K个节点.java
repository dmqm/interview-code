package coding.nowcoder;

/*
 * ��Ŀ���� ����һ�Ŷ��������������ҳ����еĵ�kС�Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 */
public class T62�����������ĵ�K���ڵ� {
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
