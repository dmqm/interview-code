package coding.nowcoder.old;
// ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
public class Test26 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public class Solution {
		TreeNode preIndex = null, head;
		public TreeNode Convert(TreeNode pRootOfTree) {
			if (pRootOfTree == null)
				return null;
			Convert(pRootOfTree.left);
			if (preIndex != null) {
				preIndex.right = pRootOfTree;
				pRootOfTree.left = preIndex;
				preIndex = pRootOfTree;
			} else {
				head = pRootOfTree;
				preIndex = pRootOfTree;
			}
			Convert(pRootOfTree.right);
			return head;

		}
	}
}
