package coding.nowcoder.old;
import java.util.Stack;

// ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
// ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
// ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
public class Test21 {
	public class Solution {
		public boolean IsPopOrder(int[] pushA, int[] popA) {
			if (pushA.length != popA.length || pushA.length == 0 || popA.length == 0)
				return false;
			int index = 0;
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < pushA.length; i++) {
				s.push(pushA[i]);
				while (!s.empty() && s.peek() == popA[index]) {
					s.pop();
					index++;
				}
			}
			return s.empty();
		}
	}
}
