package coding.nowcoder.old;
import java.util.LinkedList;

/*
 * ��Ŀ���� :ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,
 * �����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....
 * ������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 */
public class Test47 {
	public class Solution {
		public int LastRemaining_Solution(int n, int m) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < n; i++)
				list.add(i);
			int index = 0;
			while (list.size() > 1) {
				index = (index + m - 1) % list.size();
				list.remove(index);
			}
			return list.size() == 1 ? list.get(0) : -1;
		}
	}
}
