package coding.nowcoder.old;
// ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
public class Test39 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

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
