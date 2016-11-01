package Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MyReadExcel {

	// private File f;
	private static final String FILE_PATCH = "baocaoluuluongxequatram_10282016203253.xlsx";
	// private NPOIFSFileSystem poifile;
	private FileInputStream inputstream;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private void readExcel(File f) {

		if (f.exists()) {
			try {
				// i tried to use XSSFWorkbook(file) but error happening >
				// using filestream
				inputstream = new FileInputStream(f);
				workbook = new XSSFWorkbook(inputstream);
				sheet = workbook.getSheetAt(0);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(FILE_PATCH);
			}
			/*System.out.println(sheet.getSheetName());
			System.out.println("tong so row: " + sheet.getLastRowNum());
			*/
			
		} else {
			System.out.println("ERROR: File not found.");
		}

	}

	public static void main(String[] args) {

		File f = new File(FILE_PATCH);
		MyReadExcel me = new MyReadExcel();
		me.readExcel(f);
	}

}
