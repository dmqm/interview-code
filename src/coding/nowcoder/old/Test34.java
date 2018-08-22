package coding.nowcoder.old;
// 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
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
