package coding.recruit17;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��Ŀ����
 * ��һƬ1000*1000�Ĳݵأ�С�׳�ʼվ��(1,1)(�����Ͻǵ�λ��)��С����ÿһ��������������ƶ������ڵĲݵ��ϳԲ�(С�ײ����߳��߽�)�����ɳ�����ȥ��׽�ɰ���С�ף���������n�����塣
 * ��i�����屻�����ں�����Ϊxi ��������Ϊyi ��λ���ϣ�С��һ������һ�����壬���ᱻ������׽����Ϊ��ȥ���С�ף���Ҫ֪��С�����ٶ�������ܻ�����һ�����壬�Ӷ���ǰ���С�ס� ��������:
 * 
 * ��һ��Ϊһ������n(n �� 1000)����ʾ����һ��ӵ��n�����塣 �ڶ�����n������xi����ʾ��i������ĺ����� ��������n������yi����ʾ��i������������� ��֤���궼�ڲݵط�Χ�ڡ�
 * 
 * �������:
 * 
 * ���һ������,��ʾС�����ٿ��ܶ���������볬��������
 */
public class T12���С�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] x = new int[n], y = new int[n];
			for (int i = 0; i < n; i++)
				x[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				y[i] = in.nextInt();
			int[] s = new int[n];
			for (int i = 0; i < n; i++)
				s[i] = x[i] + y[i] - 2;
			Arrays.sort(s);
			System.out.println(s[0]);
		}
	}

}
