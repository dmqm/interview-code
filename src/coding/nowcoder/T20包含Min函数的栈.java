package coding.nowcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/*
 * ��Ŀ���� ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 */
public class T20����Min������ջ {
	/*
	 * ˼·����һ��ջdata�������ݣ�������һ��ջmin����������ջ��С����
	 */
	public class Solution {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();

		public void push(int node) {
			if (minStack.size() == 0) {
				minStack.push(node);
			} else {
				int temp = minStack.peek();
				if (temp > node) {
					minStack.push(node);
				} else {
					minStack.push(temp);
				}
			}
			stack.push(node);
		}

		public void pop() {
			stack.pop();
			minStack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int min() {
			return minStack.peek();
		}
	}
	public class Solution2 {
		ArrayList<Integer> list = new ArrayList<Integer>();

		public void push(int node) {
			list.add(node);
		}

		public void pop() {
			list.remove(list.size() - 1);
		}

		public int top() {
			return list.get(list.size() - 1);
		}

		public int min() {
			Iterator<Integer> it = list.iterator();
			int min = it.next();
			while (it.hasNext())
				min = Math.min(min, it.next());
			return min;
		}
	}
}
