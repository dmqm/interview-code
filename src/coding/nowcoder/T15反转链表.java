package coding.nowcoder;

/*
 * ��Ŀ���� ����һ��������ת�����������������Ԫ�ء�
 */
public class T15��ת���� {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode ReverseList(ListNode head) {
			if (head == null)
				return head;
			ListNode left = head, right = head.next, temp;
			left.next = null;
			while (right != null) {
				temp = right;
				right = right.next;
				temp.next = left;
				left = temp;
			}
			return left;
		}
	}
}
