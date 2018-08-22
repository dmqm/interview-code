package coding.nowcoder;

/*
 * 题目描述 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class T26二叉搜索树和双向链表 {
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
			if (preIndex == null) {
				head = pRootOfTree;
				preIndex = pRootOfTree;
			} else {
				preIndex.right = pRootOfTree;
				pRootOfTree.left = preIndex;
				preIndex = pRootOfTree;
			}
			Convert(pRootOfTree.right);
			return head;
		}
	}
}
