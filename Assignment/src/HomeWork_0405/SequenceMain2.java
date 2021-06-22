package HomeWork_0405;

public class SequenceMain2 {

	public static void main(String[] args) {
	
		String pre = new String("1");
		String next = "";
		int index = 0;

		while (index < 10) {
			next = prnLine(pre);
			pre = next;
			index++;
		}
	}

	public static String prnLine(String pre) {

		String next = "";
		System.out.println(pre);
		for (int i = 0; i < pre.length(); i++) {
			if (i > 0) {
				if (pre.charAt(i - 1) == pre.charAt(i)) {
					continue;
				}
			}
			next += numberOf(pre, i);
		}
		return next;
	}

	private static String numberOf(String preLine, int index) {

		char str = preLine.charAt(index);
		int cnt = 0;

		for (int j = index; j < preLine.length(); j++) {
			if (str == preLine.charAt(j)) {
				cnt++;
			} else {
				break;
			}
		}
		return str + Integer.toString(cnt);
	}
}