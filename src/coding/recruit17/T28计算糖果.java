package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� A,B,C�������Ǻ�����,ÿ�������ﶼ��һЩ�ǹ�,���ǲ�֪������ÿ�������Ͼ����ж��ٸ��ǹ�,��������֪�����µ���Ϣ�� A - B, B - C, A + B, B + C.
 * ���ĸ���ֵ.ÿ����ĸ����ÿ������ӵ�е��ǹ���. ������Ҫͨ�����ĸ���ֵ�����ÿ���������ж��ٸ��ǹ�,��A,B,C�����ﱣ֤���ֻ��һ������A,B,C������������������ ��������:
 * 
 * ����Ϊһ�У�һ��4���������ֱ�ΪA - B��B - C��A + B��B + C���ÿո������ ��Χ����-30��30֮��(������)��
 * 
 * �������:
 * 
 * ���Ϊһ�У�����������������A��B��C��˳�����A��B��C���ÿո��������ĩ�޿ո� �������������������A��B��C�������No
 */
public class T28�����ǹ� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int AsubB = in.nextInt(), BsubC = in.nextInt(), AplusB = in.nextInt(), BplusC = in.nextInt();
			int A = (AsubB + AplusB) / 2;
			int B = AplusB - A;
			int C = B - BsubC;
			if (BplusC == B + C && (AsubB + AplusB) % 2 == 0 && (BsubC + BplusC) % 2 == 0)
				System.out.println(A + " " + B + " " + C);
			else
				System.out.println("No");
		}
	}

}
