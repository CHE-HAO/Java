package units;

import org.junit.Test;

public class Prime {

	@Test
	public void test() {

	}

	/**
	 * 若為質數，回傳true
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPrime(int num) {
		boolean result = false;
		if (num > 1) {
			int i = num - 1;
			while (num % i != 0)
				i--;
			result = (i == 1);
		}
		return result;
	}

	/**
	 * 輸入要取得幾個質數
	 * 
	 * @param count
	 * @return
	 */
	public int[] getPrimeArray(int count) {
		int[] result = new int[count];
		int index = 0;
		for (int i = 1; index < count; i++) {
			if (isPrime(i)) {
				result[index] = i;
				index++;
			}
		}
		return result;
	}
}
