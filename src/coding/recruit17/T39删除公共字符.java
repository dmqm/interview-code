package coding.recruit17;


import java.util.Scanner;

public class T39É¾³ý¹«¹²×Ö·û {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String src = in.nextLine();
		String pattern = in.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			if (pattern.indexOf(src.charAt(i)) == -1) {
				sb.append(src.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
