package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ����С����һ��W*H��������ӣ�������б��Ϊ0~H-1��������б��Ϊ0~W-1��ÿ������������Է�һ�鵰�⣬�������鵰���ŷ����þ��벻�ܵ���2��
 * ����������������(x1,y1),(x2,y2)��ŷ����þ���Ϊ: ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) ������ƽ����
 * С����֪�������ԷŶ��ٿ鵰������������ ��������:
 * 
 * ÿ������������񳤿�W,H���ÿո�ָ�.(1 �� W��H �� 1000)
 * 
 * �������:
 * 
 * ���һ�������Էŵĵ�����
 */
public class T11��Ҫ�� {

	/*
	 * ֻҪ�������ÿ��4���У� i��i��1�еĵ�����Ϊ (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2) i��2��i+3�еĵ�����Ϊ ((n - 2) / 4) *
	 * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2) Ȼ�������һ���ж��ٸ�������4�о��У� ��Ȼ�ǹ���m / 4 ����
	 * ΨһҪע��ľ��Ǵ���������4���������������������ʣ���1��3 �мӽ�ȥ��
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt();
		int evenICount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
		int oddICount = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
		int ans = m / 4 * (evenICount + oddICount) * 2;
		if (m % 4 > 0)
			ans += evenICount;
		if (m % 4 > 1)
			ans += evenICount;
		if (m % 4 > 2)
			ans += oddICount;
		System.out.println(ans);
	}

}
