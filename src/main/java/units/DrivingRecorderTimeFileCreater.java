package units;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.junit.Test;

import utils.DateUtils;

/**
 * 產出獵豹M1行車紀錄器的時間檔案格式 
 * 預設為當前時間+5分鐘
 * 
 * @author Justin
 */
public class DrivingRecorderTimeFileCreater {

	private final String FILE_PATH = "D:\\"; // 檔案目錄
	private final int later = 5; // 延後時間

	private BufferedWriter bw;

	@Test
	public void genFile() {
		File f = new File(getFilePath());

		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "UTF-8"));
			bw.append(getTime());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private String getFilePath() {
		return FILE_PATH + "time.txt";
	}

	private String getTime() {
		return DateUtils.format(DateUtils.addMinutes(new Date(), later), "yyyy MM dd HH mm ss");
	}
}
