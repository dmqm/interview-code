package coding.nowcoder.old;

/*
 * ��Ŀ���� ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
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
	// ��������������ڵ㣬û�о��ҵ�һ����ǰ�ڵ�����������Ϊ�������ĸ��׽ڵ�
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
