package coding.nowcoder.old;
import java.util.Arrays;

// LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh
// My God!������˳��.....LL��������,��������,������\С
// �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
// ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
public class Test46 {
	public class Solution {
		public boolean isContinuous(int[] numbers) {
			int len = numbers.length;
			if (len == 0)
				return false;
			if (len == 1)
				return true;
			Arrays.sort(numbers);
			int zeroCount = 0;
			for (int i = 0; i < len && numbers[i] == 0; i++)
				zeroCount++;
			for (int i = zeroCount; i < len - 1; i++)
				if (numbers[i] == numbers[i + 1])
					return false;
			int charge = (numbers[len - 1] - numbers[zeroCount]) - (len - 1 - zeroCount);
			if (zeroCount >= charge)
				return true;
			return false;

		}
	}
}
