package coding.nowcoder.old;
// ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
public class Test34 {
	public class Solution {
		public int GetUglyNumber_Solution(int index) {
			if (index == 0)
				return 0;
			int[] uglyNum = new int[index];
			uglyNum[0] = 1;
			int[] ind = {0, 0, 0};
			int[] num=new int[3];
			for (int i = 1; i < index; i++) {
				num[0] = 2 * uglyNum[ind[0]];
				num[1] = 3 * uglyNum[ind[1]];
				num[2] = 5 * uglyNum[ind[2]];
				uglyNum[i] = Math.min(num[0], Math.min(num[1], num[2]));
				if(uglyNum[i]/uglyNum[ind[0]]==2)
					ind[0]++;
				if (uglyNum[i] / uglyNum[ind[1]] == 3)
					ind[1]++;
				if (uglyNum[i] / uglyNum[ind[2]] == 5)
					ind[2]++;
			}
			return uglyNum[index - 1];
		}
	}
}
