/**
 * 
 */
package Core;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.IDREFSIterator;

import javafx.animation.Interpolator;
import java.util.*;

/**
 * @author neo
 *
 */
public class ReadExcel {

	/**
	 * @param args
	 */
	
	private ArrayList row = new ArrayList();
	private ArrayList cell = new ArrayList();
	private Iterator rit = (Iterator) row.iterator();
	private Iterator cit = (Iterator) cell.iterator();
	
	private void readingDataFromFile(String pathFile) {
        File fileExcel = new File(pathFile);
        POIFSFileSystem fsExcel = null;
        try {
            fsExcel = new POIFSFileSystem(new FileInputStream(fileExcel));

            HSSFWorkbook wb = new HSSFWorkbook(fsExcel);
            HSSFSheet sheet = wb.getSheetAt(0);       // first sheet
            System.out.println("TRUONGTEST: " + sheet.getLastRowNum());
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
                Row row = rit.next();
                int rowNum = row.getRowNum();//So dong hien tai(dùng de dem so dong)
                System.out.println("So dong hien tai: " + rowNum);
                if (rowNum > 1) {
                    String masv = "";
                    String ho = "";
                    String ten = "";                   
                    int intRow = 0;//Bien dem cot cua tung dong(dây là cách giai quyet van de cua ban)
                    for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
                        Cell cell = cit.next();
                        switch (intRow) {
                            case 0:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                masv = cell.getStringCellValue();
                                intRow++;
                                break;
                            case 1:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                ho = cell.getStringCellValue();
                                intRow++;
                                break;
                            case 2:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                ten = cell.getStringCellValue();
                                intRow++;
                                break;                           
                    }
//                    System.out.println("Insert into SINHVIEN values(" + masv + "," + hoten + "," + gioitinh + "," + ngsinh + "," + noisinh + "," + hokhau + "," + diachi + ")");                   
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
