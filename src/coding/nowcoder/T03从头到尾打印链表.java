package coding.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/*
 * ��Ŀ���� ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */
public class T03��ͷ��β��ӡ���� {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			ListNode index = listNode;
			ArrayList<Integer> res = new ArrayList<Integer>();
			while (index != null) {
				res.add(0, index.val);
				index = index.next;
			}
			return res;
		}
	}

	public class Solution2 {
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			Stack<Integer> stack = new Stack<>();
			ListNode index = listNode;
			while (index != null) {
				stack.push(index.val);
				index = index.next;
			}

			ArrayList<Integer> list = new ArrayList<>();
			while (!stack.isEmpty()) {
				list.add(stack.pop());
			}
			return list;
		}
	}
}
