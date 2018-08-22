package coding.nowcoder;

/*
 * ��Ŀ���� �������������ҳ����ǵĵ�һ��������㡣
 */
public class T36��������ĵ�һ��������� {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
			ListNode index1 = pHead1, index2 = pHead2;
			while (index1 != index2) {
				index1 = index1 == null ? pHead2 : index1.next;
				index2 = index2 == null ? pHead1 : index2.next;
			}
			return index1;
		}
	}
}
