package coding.nowcoder.old;
/* дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š� */
public class Test49 {
	public class Solution {
		public int Add(int num1, int num2) {
			while (num2 != 0) {// ��λΪ0ֹͣ
				int temp = num1 ^ num2;// ���
				num2 = (num1 & num2) << 1;// ��λ
				num1 = temp;
			}
			return num1;
		}
	}
	public class Solution2 {
		public int Add(int num1, int num2) {
			return Math.addExact(num1, num2);
		}
	}
}
