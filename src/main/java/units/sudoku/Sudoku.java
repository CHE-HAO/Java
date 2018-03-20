package units.sudoku;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Sudoku {
	
	private int[][] sudoku = new int[9][9];
	
	public int[][] getSuDoKu(int[][] sudoku){
		
		
		
		return null;
	}
	
	private boolean checkListIsCorrect(int[] testNums){
		Set<Integer> testMap = new HashSet<Integer>();
		for(int i : testNums){
			if(checkNumRange(i)){
				testMap.add(i);
			}else{
				return false;
			}
		}
		return testMap.size() == 9;
	}
	
	private boolean checkNumRange(int num){
		return num > 0 && num <= 9;
	}

	private void printSudoku(){
		StringBuilder sb = new StringBuilder();
		for(int[] row : sudoku){
			sb.append("|");
			for(int num : row){
				sb.append(num).append("|");
			}
			sb.append("\n").append("-------------------").append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	@Test
	public void jUnitTest() {
//		boolean b = checkListIsCorrect(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//		System.out.println(b);
		printSudoku();
		
	}
}
