package coding.nowcoder.old;
// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class Test04 {

	public class Solution {
		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			return bulidBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

		public TreeNode bulidBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
			TreeNode res = null;
			if (preStart > preEnd || inStart > inEnd)
				return res;
			res = new TreeNode(pre[preStart]);
			if (preEnd - preStart == 0)
				return res;
			int index = getIndex(pre[preStart], inStart, inEnd, in);
				res.left = bulidBinaryTree(pre, preStart + 1, preStart + index - inStart, in, inStart, index - 1);
				res.right = bulidBinaryTree(pre, preStart + index - inStart + 1, preEnd, in, index + 1, preEnd);
			return res;
		}

		public int getIndex(int des, int start, int end, int[] src) {
			for (int i = start; i <= end; i++) {
				if (src[i] == des)
					return i;
			}
			return -1;
		}
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
