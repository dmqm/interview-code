package coding.nowcoder;

/*
 * ��Ŀ���� һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 */
public class T08��̨�� {
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
