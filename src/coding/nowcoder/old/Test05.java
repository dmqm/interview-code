package coding.nowcoder.old;
import java.util.Stack;

// ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			while (stack2.isEmpty()) {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
			}
			return stack2.pop();

		}
	}

}
