package Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

public class MyReadExcel {
	
//	private File f;
	private static final String FILE_PATCH = "baocaoluuluongxequatram_10282016203253.xls";
	private POIFSFileSystem poifile;
	private FileInputStream inputstream;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	
	
	private void readExcel(File f){
		
		try {
//			f= new File(FILE_PATCH);
			inputstream = new FileInputStream(f);
			poifile = new POIFSFileSystem(inputstream);
			workbook = new HSSFWorkbook(poifile);
			sheet = workbook.getSheetAt(1);
			System.out.println(sheet.getSheetName());
			System.out.println("tong so row: "+ sheet.getLastRowNum());
			
			/*for(Iterator rit = (Iterator)sheet.rowIterator(); rit.next();){
				System.out.println(sheet.rowIterator());
				
			}*/
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(FILE_PATCH);
		}
		
	}

	public static void main(String[] args) {
		
		File f = new File(FILE_PATCH);		
		MyReadExcel me = new MyReadExcel();
		me.readExcel(f);
	}

}
