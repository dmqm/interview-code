package coding.nowcoder.old;
// һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int JumpFloor(int target) {
			if (target <= 2)
				return target;
			int res = 2;
			int old = 1, temp;
			for (int i = 2; i < target; i++) {
				temp = res;
				res = res + old;
				old = temp;
			}
			return res;
		}
	}
}
