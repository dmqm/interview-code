package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ���� һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */
public class T55�����л�����ڽڵ� {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public ListNode EntryNodeOfLoop(ListNode pHead) {
			if (pHead == null || pHead.next == null || pHead.next.next == null)
				return null;
			ListNode fast = pHead.next.next;
			ListNode slow = pHead.next;
			///// ���ж���û�л�
			while (fast != slow) {
				if (fast.next != null && fast.next.next != null) {
					fast = fast.next.next;
					slow = slow.next;
				} else {
					// û�л�,����
					return null;
				}
			}
			// ѭ�������Ļ������л����Ҵ�ʱfast==slow.
			fast = pHead;
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
			return slow;
		}
	}

	public class Solution2 {
		public ListNode EntryNodeOfLoop(ListNode pHead) {
			if (pHead == null || pHead.next == null)
				return null;
			ArrayList<ListNode> al = new ArrayList<ListNode>();
			ListNode index = pHead;
			while (index != null) {
				if (al.contains(index))
					return index;
				al.add(index);
				index = index.next;
			}
			return null;
		}
	}
}
