package coding.nowcoder;

/*
 * ��Ŀ���� ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
public class T56ɾ���������ظ��Ľڵ� {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode deleteDuplication(ListNode pHead) {
			ListNode pHeadNew = new ListNode(-1);
			pHeadNew.next = pHead;
			ListNode index = pHead;
			ListNode indexPre = pHeadNew;
			while (index != null)
				if (index.next != null && index.val == index.next.val) {
					index = index.next;
					while (index != null && indexPre.next.val == index.val)
						index = index.next;
					indexPre.next = index;
				} else {
					indexPre = index;
					index = indexPre.next;
				}
			return pHeadNew.next;
		}
	}
}
