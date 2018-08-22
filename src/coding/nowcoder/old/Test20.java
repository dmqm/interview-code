package coding.nowcoder.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
public class Test20 {
	public class Solution {
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

	public class Solution2 {
		Stack<Integer> data = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		Integer temp = null;

		public void push(int node) {
			if (temp != null) {
				if (node <= temp) {
					temp = node;
					min.push(node);
				}
				data.push(node);
			} else {
				temp = node;
				data.push(node);
				min.push(node);
			}
		}

		public void pop() {
			int num = data.pop();
			int num2 = min.pop();
			if (num != num2) {
				min.push(num2);
			}
		}

		public int top() {
			int num = data.pop();
			data.push(num);
			return num;
		}

		public int min() {
			int num = min.pop();
			min.push(num);
			return num;
		}
	}

	public class Solution3 {
		/*
		 * 借用辅助栈存储min的大小，自定义了栈结构,栈存储每次入栈出栈的min
		 */
		private int size;
		private int min = Integer.MAX_VALUE;
		private Stack<Integer> minStack = new Stack<Integer>();
		private Integer[] elements = new Integer[10];

		public void push(int node) {
			ensureCapacity(size + 1);
			elements[size++] = node;
			if (node <= min) {
				minStack.push(node);
				min = minStack.peek();
			} else {
				minStack.push(min);
			}
		}

		private void ensureCapacity(int size) {
			// TODO Auto-generated method stub
			int len = elements.length;
			if (size > len) {
				int newLen = (len * 3) / 2 + 1; // 每次扩容方式
				elements = Arrays.copyOf(elements, newLen);
			}
		}

		public void pop() {
			Integer top = top();
			if (top != null) {
				elements[size - 1] = null;
			}
			size--;
			minStack.pop();
			min = minStack.peek();
		}

		public int top() {
			if (!empty()) {
				if (size - 1 >= 0)
					return elements[size - 1];
			}
			return -1;
		}

		public boolean empty() {
			return size == 0;
		}

		public int min() {
			return min;
		}
	}

}
