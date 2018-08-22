package coding.nowcoder.old;

/*
 * 题目描述 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Test58 {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}
	// 先右子树的最左节点，没有就找第一个当前节点所在子树作为左子树的父亲节点
	public class Solution2 {
		public TreeLinkNode GetNext(TreeLinkNode pNode) {
			TreeLinkNode currentIndex = pNode, parentIndex = pNode;
			if (currentIndex.next != null)
				parentIndex = currentIndex.next;
			if (currentIndex.right != null) {
				currentIndex = currentIndex.right;
				while (currentIndex.left != null)
					currentIndex = currentIndex.left;
				return currentIndex;
			} else {
				while (currentIndex != parentIndex.left && currentIndex != parentIndex) {
					currentIndex = parentIndex;
					if (parentIndex.next != null)
						parentIndex = parentIndex.next;
				}
				if (currentIndex == parentIndex)
					return null;
				return parentIndex;
			}
		}
	}
}
