package Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAcces {
	String nombreArchivo = "excel1";
	static String rutaArchivo = "C:\\Users\\alu2017440\\eclipse-workspace\\JspProject1\\src\\Files\\excel1.xlsx";
	static int hoja = 0;
	static ArrayList<String> excellist = new ArrayList<>();
	static ArrayList<ArrayList<String>> excelTable;
	static int numHojas = 0;
	static ArrayList<String> hojasName = new ArrayList<String>();

	
	public static void read() {
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			
			
			//Obetener el numero de hojas que tiene el archivo
			int countSheet = worbook.getActiveSheetIndex();
			numHojas = worbook.getActiveSheetIndex();
			
			for (int i = 0; i < numHojas; i++) {
				hojasName.add(worbook.getSheetAt(i).getSheetName());
			}
			
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(hoja);
			
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();

			Row row;
			//mat
			excelTable = new ArrayList<ArrayList<String>>();
			
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				ArrayList <String>fila = new ArrayList<String>();
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					//rellenas ArrayL
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
					if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.print(cell.getStringCellValue()+" | ");
						excellist.add(cell.getStringCellValue());
						fila.add(cell.getStringCellValue());
					} else {
						System.out.print(cell.getNumericCellValue() + " | ");
						excellist.add(String.valueOf(cell.getNumericCellValue()));
						fila.add(String.valueOf(cell.getNumericCellValue()));
					}
					
					
				}
				for (int i = 0; i < excellist.size(); i++) {
					System.out.print(excellist.get(i));
				}
				excelTable.add(fila);
				System.out.println("");
				//add a matriz
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static ArrayList<String> list() {
		return excellist;
	}

	public static ArrayList<ArrayList<String>> getExcelTable() {
		return excelTable;
	}

	public static int getNumHojas() {
		return numHojas;
	}

	public static void setNumHojas(int numHojas) {
		ExcelAcces.numHojas = numHojas;
	}

	public static ArrayList<String> getHojasName() {
		return hojasName;
	}

	public static void setHojasName(ArrayList<String> hojasName) {
		ExcelAcces.hojasName = hojasName;
	}


	
	
	

	



}
