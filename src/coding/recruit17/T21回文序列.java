package coding.recruit17;

/*
 * ��Ŀ���� ���һ��������������֮���ԭ������һ���ľͳ���������������Ϊ�������С����磺 {1, 2, 1}, {15, 78, 78, 15} , {112} �ǻ�������, {1, 2, 2},
 * {15, 78, 87, 51} ,{112, 2, 11} ���ǻ������С� ���ڸ���һ���������У�����ʹ��һ��ת��������
 * ѡ�������������ڵ�����Ȼ��������Ƴ������������������������ֵĺͲ��뵽��������֮ǰ��λ��(ֻ����һ����)�� ���ڶ�����������Ҫ���������Ҫ���ٴβ������Խ����ɻ������С� ��������:
 * 
 * ����Ϊ���У���һ��Ϊ���г���n ( 1 �� n �� 50) �ڶ���Ϊ�����е�n������item[i] (1 �� iteam[i] �� 1000)���Կո�ָ���
 * 
 * �������:
 * 
 * ���һ��������ʾ������Ҫ��ת������
 */
import java.util.Scanner;

public class T21�������� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] item = new int[n];
			for (int i = 0; i < n; i++)
				item[i] = in.nextInt();
			int low = 0, lowsum = item[low], high = n - 1, highsum = item[high];
			int res = 0;
			while (low < high)
				if (lowsum < highsum) {
					res++;
					lowsum += item[++low];
				} else if (lowsum > highsum) {
					res++;
					highsum += item[--high];
				} else {
					lowsum = item[++low];
					highsum = item[--high];
				}
			System.out.println(res);
		}
	}
}
