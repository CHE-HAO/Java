package units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 因數與倍數
 * @author Justin
 */
public class FactorsAndMultiples {

	@Test
	public void doTest(){
//		int[] num = {847, 417};	//在這裡輸入所有要測試的數字
//		System.out.println(getHighestCommonFactor(num));
//		System.out.println(getLeastCommonMultiple(num));
		
//		System.out.println("=============");
//		for(Integer i : getCommonFactor(130)){
//			System.out.println(i.intValue());
//		}
//		System.out.println("=============");
	}
	
	/**
	 * 輸入一數字，取得所有因數
	 * @param num
	 * @return
	 */
	public List<Integer> getCommonFactor(int num){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 1 ; i < num ; i++){
			if(num % i == 0) result.add(i);
		}
		result.add(num);
		return result;
	}
	
	/**
	 * 輸入數字為一陣列，回傳最大公因數
	 * @param num
	 * @return
	 */
	public int getHighestCommonFactor(int[] num){
		Arrays.sort(num);
		int result = 0;
		if(num.length > 0){
			for(int i = 1 ; i <= num[0] ; i++){
				//-------------------------------------
				boolean check = true;
				for(int j = 0 ; j < num.length ; j++)
					if(num[j] % i != 0)
						check = false;
				//-------------------------------------
				if(check) result = i;
			}
		}
		return result;
	}

	/**
	 * 輸入數字為一陣列，回傳最小公倍數
	 * @param num
	 * @return
	 */
	public int getLeastCommonMultiple(int[] num){
		Arrays.sort(num);
		int result = 0;
		if(num.length > 0){
			int max = num[num.length-1];	//最大值
			//---------------------------------------
			boolean loop = true;
			do{
				boolean check = true;
				for(int i = 0 ; i < num.length ; i++)
					if(max % num[i] != 0)
						check = false;
				loop = !check;
				if(loop) max++;
			}while(loop);
			//---------------------------------------
			result = max;
		}
		return result;
	}
	
}
