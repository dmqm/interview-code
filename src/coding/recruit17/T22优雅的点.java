package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� С����һ��Բ��������ԭ���Բ��С��֪��Բ�İ뾶��ƽ����С����Ϊ��Բ�ϵĵ���Һ������궼�������ĵ������ŵģ�С��������Ѱ��һ���㷨��������ŵĵ�ĸ������������������
 * ���磺�뾶��ƽ�����Ϊ25 ���ŵĵ���У�(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)��һ��12���㡣 ��������:
 * 
 * ����Ϊһ����������ΪԲ�뾶��ƽ��,��Χ��32λint��Χ�ڡ�
 * 
 * �������:
 * 
 * ���Ϊһ����������Ϊ���ŵĵ�ĸ���
 */
public class T22���ŵĵ� {
	// ��ʱ����
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long sqr = in.nextInt();
			int r = (int) Math.sqrt(sqr);
			int res = 0;
			for (int x = 1; x <= r; x++) {
				int limit = (int) Math.sqrt(sqr - x * x);
				for (int y = 0; y <= limit; y++)
					if (x * x + y * y == sqr)
						res += 4;
			}
			System.out.println(res);
		}
	}

	// ���˵�
	public static class Main {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int rSquare = in.nextInt();
			int count = 0;
			double r = Math.sqrt(rSquare);

			// �洢ֵ
			for (int i = 0; i < r; i++) {
				/*
				 * ���г�ʱ for(int j=1;j<r+1;j++){ if(i*i+j*j==rSquare){ count++; } }
				 */
				// �Ż���1
				double j = Math.sqrt(rSquare - i * i);
				if ((int) j == j) {
					count++;
				}
			}

			// �Ż���2
			System.out.print(count << 2);

		}
	}

}
