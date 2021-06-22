package HomeWork_0405;

public class SequenceMain {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("1");

		for (int i = 0; i < 10; i++) {
			System.out.println(sb.toString());
			String[] temp = sb.toString().split("");
			sb = new StringBuilder();
			int cnt = 0;
			for (int j = 0; j < temp.length; j++) {
				if ( temp[0].equals(temp[j])) {
					cnt++;
				} else {
					sb.append( temp[0] + "" + cnt);
					 temp[0] = temp[j];
					cnt = 1;
				}
			}
			if (cnt >= 1) {
				sb.append( temp[0] + "" + cnt);
				cnt = 1;
			}
		}
	}
}
