package Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyReadExcel {

	private static final String FILE_PATCH = "baocaoluuluongxequatram_10282016203253.xlsx";
//	private NPOIFSFileSystem poifile;
	private FileInputStream inputstream;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private ArrayList<Staff> lStaff = new ArrayList<Staff>();

	private void readExcel(File f) {

		if (f.exists() && f.canRead()) {
			try {
				// i tried to use XSSFWorkbook(file) but error happening >
				// using filestream
				inputstream = new FileInputStream(f);
				workbook = new XSSFWorkbook(inputstream);
				sheet = workbook.getSheetAt(1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(FILE_PATCH);
			}
			
			if(sheet != null && sheet.getLastRowNum() > 0){
				/*
				 * The first row is Heading, so we must get the second row
				 */
				for(int i = 1; i <= sheet.getLastRowNum(); i++){
					Row row = sheet.getRow(i);
					if(row != null && row.getLastCellNum() > 0){
						Staff sta = new Staff();
						//get data from cell 1 of the Row
						//Rows are indexed from zero, so we must get from cell 0
						Cell cell = row.getCell(0);
						sta.setFirst_Name(cell.getStringCellValue());
						
						//cell 2
						cell = row.getCell(1);
						sta.setLast_Name(cell.getStringCellValue());
						
						//cell 3
						cell = row.getCell(2);
						sta.setThe_age((int) cell.getNumericCellValue());
						
						//cell 4
						cell = row.getCell(3);
						sta.setThe_sex(cell.getStringCellValue());
						
						//cell 5
						cell = row.getCell(4);
						sta.setThe_address(cell.getStringCellValue());
						
						//cell 6
						cell = row.getCell(5);
						sta.setThe_phoneNumber(cell.getStringCellValue());

						//cell 7
						cell = row.getCell(6);
						sta.setThe_identificationnumber((long) cell.getNumericCellValue());
//						lStaff.add(sta);
						System.out.println(sta.getThe_age() +" - "+ sta.getThe_phoneNumber()+"-"+sta.getThe_identificationnumber());
					}
				}
				
				
			}else{
				System.out.println("ERROR: sheet is empty: " + FILE_PATCH);
			}
			
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
