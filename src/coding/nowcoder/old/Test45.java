package coding.nowcoder.old;
// ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼�����磬��student.
// a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
public class Test45 {
	public class Solution {
		public String ReverseSentence(String str) {
			String[] array = str.split(" ");
			if (array.length == 0)
				return str;
			StringBuilder res = new StringBuilder();
			for (int i = array.length - 1; i > 0; i--)
				res.append(array[i]).append(" ");
			res.append(array[0]);
			return res.toString();
		}
	}
}
