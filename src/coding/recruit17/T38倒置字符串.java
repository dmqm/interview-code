package coding.recruit17;


/*
 * ��Ŀ���� ��һ�仰�ĵ��ʽ��е��ã���㲻���á����� I like beijing. �����������Ϊ��beijing. like I ��������:
 * 
 * ÿ�������������1������������ I like beijing. �����������Ȳ�����100
 * 
 * �������:
 * 
 * �����������֮����ַ���,�Կո�ָ�
 * 
 * ʾ��1 ���� ����
 * 
 * I like beijing.
 * 
 * ��� ����
 * 
 * beijing. like I
 * 
 * 
 */
import java.util.Scanner;

public class T38�����ַ��� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] src = in.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = src.length - 1; i >= 0; i--) {
			sb.append(src[i]).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}
}
