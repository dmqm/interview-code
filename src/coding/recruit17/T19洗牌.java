package coding.recruit17;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��Ŀ���� ϴ����������ʮ�ֳ�����������Ҫдһ������ģ��ϴ�ƵĹ��̡�
 * ������Ҫϴ2n���ƣ����ϵ��������ǵ�1�ţ���2�ţ���3��һֱ����2n�š����ȣ����ǰ���2n���Ʒֳ����ѣ��������ŵ�1�ŵ���n�ţ��ϰ�ѣ����������ŵ�n+1�ŵ���2n�ţ��°�ѣ���
 * ���žͿ�ʼϴ�ƵĹ��̣��ȷ������ֵ����һ���ƣ��ٷ������ֵ����һ���ƣ����ŷ������ֵĵ����ڶ����ƣ��ٷ������ֵĵ����ڶ����ƣ�ֱ�����������ֵĵ�һ���ơ����Ű��ƺϲ������Ϳ����ˡ�
 * ������6���ƣ��ʼ�Ƶ�������1,2,3,4,5,6�����ȷֳ����飬��������1,2,3����������4,5,6����ϴ�ƹ����а�˳�������6,3,5,2,4,1�������������ٴκϳ�һ����֮��
 * ���ǰ��մ������µ�˳�������ƣ��ͱ��������1,4,2,5,3,6�� ���ڸ���һ��ԭʼ���飬������⸱��ϴ��k��֮��������µ����С� ��������:
 * 
 * ��һ��һ����T(T �� 100)����ʾ��������������ÿ�����ݣ���һ��������n,k(1 �� n,k �� 100)��������һ����2n����a1,a2,...,a2n(1 �� ai ��
 * 1000000000)����ʾԭʼ������ϵ��µ����С�
 * 
 * �������:
 * 
 * ����ÿ�����ݣ����һ�У����յ����С�����֮���ÿո��������Ҫ����ĩ�������Ŀո�
 */
public class T19ϴ�� {
	// ���˵ķ����������ǰ��С�ڵ���n���������֣��������´γ��ֵ�λ���� 2*��ǰλ��-1 �� �����ǰλ�ô���n���������֣�,�����´γ��ֵ�λ���� 2*����ǰλ�� - n��
	public static class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int groups = sc.nextInt();
			while (groups-- > 0) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				int[] res = new int[2 * n];
				for (int i = 0; i < 2 * n; i++) {
					int tmp = i + 1;
					for (int j = 0; j < k; j++) {
						if (tmp <= n)
							tmp = 2 * tmp - 1;
						else
							tmp = 2 * (tmp - n);
					}
					res[tmp - 1] = sc.nextInt();
				}
				// ���
				if (res.length > 0)
					System.out.print(res[0]);
				for (int i = 1; i < 2 * n; i++) {
					System.out.print(" " + res[i]);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			ArrayList<Integer[]> list = new ArrayList<Integer[]>();
			for (int i = 0; i < T; i++) {
				int n = in.nextInt();
				int k = in.nextInt();
				Integer[] ai = new Integer[n * 2];
				for (int j = 0; j < 2 * n; j++)
					ai[j] = in.nextInt();
				for (int j = 0; j < k; j++) {
					int left = 0, right = n;
					Integer[] temp = new Integer[n * 2];
					for (int l = 0; l < 2 * n; l += 2) {
						temp[l] = ai[left++];
						temp[l + 1] = ai[right++];
					}
					for (int l = 0; l < 2 * n; l += 2) {
						ai[l] = temp[l];
						ai[l + 1] = temp[l + 1];
					}
				}
				list.add(ai);
			}
			for (int i = 0; i < T; i++) {
				StringBuilder sb = new StringBuilder();
				Integer[] fin = list.get(i);
				for (int j = 0; j < fin.length; j++)
					sb.append(fin[j] + " ");
				System.out.println(sb.substring(0, sb.length() - 1));
			}
		}
	}

}
