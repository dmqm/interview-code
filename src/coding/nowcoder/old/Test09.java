package coding.nowcoder.old;
// һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
public class Test09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int JumpFloorII(int target) {
			if (target <= 2)
				return target;
			int res = 2;
			for (int i = 2; i < target; i++) {
				res <<= 1;
			}
			return res;

		}
	}

}
