package coding.nowcoder;

/*
 * ��Ŀ���� ����һ����������������е�����k����㡣
 */
public class T14�����е�����K���ڵ� {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode FindKthToTail(ListNode head, int k) {
			if (k < 0)
				return null;
			ListNode index1 = head, index2 = head;
			for (int i = 0; i < k; i++) {
				if (index1 == null)
					return null;
				index1 = index1.next;
			}
			while (index1 != null) {
				index1 = index1.next;
				index2 = index2.next;
			}
			return index2;
		}
	}
}
