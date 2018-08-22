package coding.nowcoder;

/*
 * ��Ŀ����
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,
 * 1,5,3,8,6}�����ؽ������������ء�
 */
public class T04�ؽ������� {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

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

	public class Solution2 {


		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			if (pre == null || in == null) {
				return null;
			}

			java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
			for (int i = 0; i < in.length; i++) {
				map.put(in[i], i);
			}
			return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
		}

		public TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, java.util.HashMap<Integer, Integer> map) {

			if (pi > pj) {
				return null;
			}
			TreeNode head = new TreeNode(p[pi]);
			int index = map.get(p[pi]);
			head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
			head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
			return head;
		}



	}
}
