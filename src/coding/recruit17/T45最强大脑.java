package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� СB�˻𳵺�������һ����N�е�M��֮�����С�����·;��ʱ˯ʱ�ѡ����������ۿ�����ķ羰ʱ��ע�⵽ÿ����վ����һ���ر���ɫ�����ģ����������������Ľ����Ǿ�����һС���֡�
 * СB�ڳ˳����������������ѵ�ʱ�䣬�������ó��յ�ʱ����˯���С���վʱ������������̸����һ·�ļ��ţ������Ǿ��ú�����˼�����ǰ�N����M֮�侭����վ��������ɫ�����г�����
 * Ȼ�������СB�ǵõ�������ɫ���У������ж�СB�����Ǵ�N��M֮����Щ������ܿ�����˵��ɫ�����ģ����Ǹ����Ͳ����ܿ�������ɫ����ĸ������ͬ����ĸ������ͬ����ɫ����ͬ����ĸ���ʾ��ͬ����ɫ��
 * ��������:
 * 
 * �������ж���������ݣ�ÿ��������ݰ������У���һ��Ϊһ����Сд������ĸ���ɵķǿ��ַ��������Ȳ�����10^5����ʾN��M֮�䳵վ����ɫ���𳵴�M��N����ʱ�������ĳ�վ��ͬ��ֻ�Ƿ����෴��
 * �ڶ���ΪСB�ڵ�һ��˯��ʱ��������ɫ���У�������ΪСB�ڵڶ���˯��ʱ��������ɫ���С��������ж���Сд��������ĸ���ɵ��ַ��������Ȳ�����100����ĸ��
 * ÿ�����е���ɫ˳�����а�СB������ʱ��˳�����С�
 * 
 * �������:
 * 
 * ��ÿ��������ݣ��ڵ������������СB�����з���
 * 
 * forward - ��N��M����
 * 
 * backward -��M��N����
 * 
 * both - ���ַ����п��ܣ�
 * 
 * invalid - �����ܿ�����������ɫ���У�
 * 
 * ʾ��1 ���� ����
 * 
 * atob a b aaacaaa aca aa
 * 
 * ��� ����
 * 
 * forward both
 * 
 */
public class T45��ǿ���� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder nTOM = new StringBuilder(in.nextLine());
		String a = in.nextLine();
		String b = in.nextLine();
		boolean forward = findForward(nTOM.toString(), a, b);
		boolean backward = findForward(nTOM.reverse().toString(), b, a);
		String res;
		if (forward && backward) {
			res = "both";
		} else if (forward) {
			res = "forward";
		} else if (backward) {

			res = "backward";
		} else {
			res = "invalid";
		}
		System.out.println(res);
	}

	public static boolean findForward(String src, String a, String b) {
		int indexA = src.indexOf(a);
		if (indexA == -1) {
			return false;
		}
		int indexB = src.indexOf(b, indexA + a.length());
		if (indexB != -1) {
			return true;
		}
		return false;
	}



	// ��ǿ����
	public static void main2(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String a = in.nextLine();
			String b = in.nextLine();
			boolean nx = nx(str, a, b);
			boolean sx = sx(str, a, b);
			if (nx && sx)
				System.out.println("both");
			else if (nx)
				System.out.println("backward");
			else if (sx)
				System.out.println("forward");
			else
				System.out.println("invalid");
		}
	}

	// �����ж�
	public static boolean nx(String str, String a, String b) {
		int aidx = str.lastIndexOf(a);
		int bidx = str.indexOf(b);
		if (aidx != -1 && bidx != -1 && bidx + b.length() - 1 < aidx)
			return true;
		return false;
	}

	// ˳���ж�
	public static boolean sx(String str, String a, String b) {
		int aidx = str.indexOf(a);
		int bidx = str.lastIndexOf(b);
		if (aidx != -1 && bidx != -1 && aidx + a.length() - 1 < bidx)
			return true;
		return false;
	}

}
