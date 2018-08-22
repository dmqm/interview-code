package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k
 * ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻��� ��������:
 * 
 * ÿ��������� 1 ������������ÿ���������ݵĵ�һ�а���һ������ n (1 <= n <= 50)����ʾѧ���ĸ�������������һ�У����� n ����������˳���ʾÿ��ѧ��������ֵ ai��-50 <=
 * ai <= 50������������һ�а�������������k �� d (1 <= k <= 10, 1 <= d <= 50)��
 * 
 * �������:
 * 
 * ���һ�б�ʾ���ĳ˻���
 */
public class T01�ϳ��� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ai = new int[n];
		for (int i = 0; i < n; i++)
			ai[i] = in.nextInt();
		int k = in.nextInt(), d = in.nextInt();
		long[][] min = new long[n][k], max = new long[n][k];
		for (int i = 0; i < n; i++) {
			min[i][0] = ai[i];
			max[i][0] = ai[i];
		}
		// �Ե����ϵ���
		// f[j][i]��ʾѡ��i+1��ѧ���������һ��ѧ���ǵ�j+1��
		for (int kk = 1; kk < k; kk++)
			for (int nn = kk; nn < n; nn++) {
				long MAX = Long.MIN_VALUE;
				long MIN = Long.MAX_VALUE;
				for (int l = Math.max(nn - d - 1, kk - 1); l < nn - 1; l++) {
					if (MAX < Math.max(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]))
						MAX = Math.max(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]);
					if (MIN > Math.min(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]))
						MIN = Math.min(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]);
				}
				max[nn][kk] = MAX;
				min[nn][kk] = MIN;
			}
		long res = Long.MIN_VALUE;
		for (int i = k - 1; i < n; i++)
			res = (res > max[i][k - 1]) ? res : max[i][k - 1];
		System.out.println(res);
	}
}
