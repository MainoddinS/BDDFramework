package util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataReader {

	public static HashMap<String, String> storeValues = new HashMap();
	public static List<HashMap<String, String>> data(String filepath, String sheetName){
		
		List<HashMap<String, String>> mydata = new ArrayList<>();
		
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow HeaderRow = sheet.getRow(0);
			
			for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow currentRow = sheet.getRow(i);
				
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j=0; j< currentRow.getPhysicalNumberOfCells(); j++) {
					XSSFCell currentCell= currentRow.getCell(j);
					
					switch (currentCell.getCellType())
					{
					case STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}fs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
}
