package coding.nowcoder;

/*
 * ��Ŀ���� һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */
public class T09��̬��̨�� {
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
