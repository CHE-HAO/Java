package units;


public class PrintQuarter {

	private static int ii = 10;
	
	public static void main(String[] args) {
	    
		// 建立記憶體
	    char[][] arr = new char[ii][ii]; 
	    
	    // 預先填入空白鍵
	    for (int i=0; i<ii; ++i){
	        for (int j=0; j<ii; ++j){
	            arr[i][j] = ' ';
	        }
	    }
	    
	    // 填入方框：兩條水平線、兩條垂直線
	    // 即便相互重疊也無所謂
	    for (int i=0; i<ii; ++i) arr[0][i] = '@';
	    for (int i=0; i<ii; ++i) arr[ii-1][i] = '@';
	    for (int i=0; i<ii; ++i) arr[i][0] = '@';
	    for (int i=0; i<ii; ++i) arr[i][ii-1] = '@';
	 
	    // 印出方框
	    for (int i=0; i<ii; ++i){
	        for (int j=0; j<ii; ++j){
	            System.out.print(arr[i][j]);
	        }
	        System.out.println();
	    }
	}
}
