package units;

/**
 * 費氏數列
 */
public class Fibonacci {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Long[] list = new Long[10]; // 數列長度
		for (int i = 0; i < list.length; i++) {
			if (i < 2) {
				list[i] = new Long(1).longValue();
			} else {
				list[i] = list[i - 1] + list[i - 2];
			}
			sb.append(list[i]);
			if (i != list.length - 1)
				sb.append(", ");
		}
		System.out.println(sb.toString());
	}

}
