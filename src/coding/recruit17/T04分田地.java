package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ţţ�� 15 �������������������ص���Ϸ��ţţ��������������أ���������ؿ��Կ�����һ�����Σ�ÿ��λ����һ����ֵ���ָ���صķ����Ǻ��������������ֳ� 16
 * �ݣ���Ϊ�쵼�ɲ���ţţ���ǻ�ѡ�������ܼ�ֵ��С��һ����أ� ��Ϊţţ��õ����ѣ���ϣ��ţţȡ�õ���صļ�ֵ�;����ܴ���֪�����ֵ�������Ƕ����� ��������:
 * 
 * ÿ��������� 1 ������������ÿ�����������ĵ�һ�а����������� n �� m��1 <= n, m <= 75������ʾ��صĴ�С���������� n �У�ÿ�а��� m �� 0-9
 * ֮������֣���ʾÿ��λ�õļ�ֵ��
 * 
 * �������:
 * 
 * ���һ�б�ʾţţ����ȡ�õ����ļ�ֵ��
 */
public class T04����� {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x1 = 0; // ����᷽��3��
		int x2 = 0;
		int x3 = 0;
		int y1 = 0; // �����ݷ���3��
		int y2 = 0;
		int y3 = 0;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				String string = scanner.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = string.charAt(j) - '0';
				}
			}
			int[][] sum = new int[n + 1][m + 1];
			// sum[i][j]��ʾ���϶���arr[0][0]�����¶���arr[i-1][j-1]�ľ���Ԫ�صĺ�
			// sum[1][1]��ʾarr[0][0]
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i - 1][j - 1]; // �ù�ʽ����֤����ȷ
				}
			}
			int left = 0;
			int right = sum[n][m];
			int res = 0;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (judge(mid, n, m, sum)) {
					left = mid + 1;
					res = mid;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(res);
		}
		scanner.close();
	}

	// ����arr���������϶���(i,j)�����¶���(x-1,y-1)ȷ������صļ�ֵ��
	public static int cal(int x, int y, int i, int j, int[][] sum) {
		return sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j];
	}

	// �ж�x�Ƿ�<=�������Сһ���ֵ
	public static boolean judge(int x, int n, int m, int[][] sum) {
		for (int i = 1; i <= m - 3; i++) {
			for (int j = i + 1; j <= m - 2; j++) {
				for (int k = j + 1; k <= m - 1; k++) {
					int last = 0;
					int cnt = 0;
					for (int r = 1; r <= n; r++) {
						int s1 = cal(r, i, last, 0, sum);
						int s2 = cal(r, j, last, i, sum);
						int s3 = cal(r, k, last, j, sum);
						int s4 = cal(r, m, last, k, sum);
						// ��ǰ����һ����������
						if (s1 >= x && s2 >= x && s3 >= x && s4 >= x) {
							last = r;
							cnt++;
						}
					}
					// ����xС�ڵ���16������е���Сֵ������true
					if (cnt >= 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
