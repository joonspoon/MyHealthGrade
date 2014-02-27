package org.wintriss.health.calculator;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelStuff {

	private String inputFile;
	private ArrayList<Location> locationList = new ArrayList<Location>();
	private InputStream excelFile;

	public ExcelStuff(InputStream excelFile){
		this.excelFile = excelFile;
		setInputFile("BehaviourData.xls");
		try {
			read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void read() throws IOException, URISyntaxException {
//		URI fileURL = getClass().getResource(inputFile).toURI();
//		File inputWorkbook = new File(fileURL);
		Workbook w;
		try {
			w = Workbook.getWorkbook(excelFile);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			addLocationsToList(sheet);

			// Loop over first 10 column and lines

			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 0; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
//						System.out.println("I got a label "
//								+ cell.getContents());
					}

					if (type == CellType.NUMBER) {
//						System.out.println("I got a number "
//								+ cell.getContents());
					}

				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	private void addLocationsToList(Sheet sheet) {
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(1, i);
			locationList.add(new Location(cell.getContents()));
		}
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(2, i);
			locationList.get(i-1).setExcersise(cell.getContents());
		}
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(3, i);
			locationList.get(i-1).setDietControl(cell.getContents());
		}
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(4, i);
			locationList.get(i-1).setSmoking(cell.getContents());
		}
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(5, i);
			locationList.get(i-1).setObese(cell.getContents());
		}
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(6, i);
			locationList.get(i-1).setFastFood(cell.getContents());
		}
	
	}
	
	private void printArray(){
		System.out.println("printing:");
		for(int i =0; i < locationList.size(); i++){
			System.out.println(locationList.get(i).getName());
		}
	}
	
	public Location getLocation(String name){
		printArray();
		for(int i = 0; i < locationList.size(); i++){
			if(locationList.get(i).getName().toLowerCase().equals(name.toLowerCase())){
				return locationList.get(i);
			}
		}
		System.out.println("Oh sh*t");
		return null;
	}
	
	public int calculateScore(Location l){
		System.out.println(l.getName());
		double score = 100;
		score -= Double.parseDouble(l.getDietControl().substring(0,2))*0.20;
		score -= Double.parseDouble(l.getExcersise().substring(0,2))*0.20;
		score -= Double.parseDouble(l.getObese().substring(0,2))*0.20;
		score -= Double.parseDouble(l.getFastFood().substring(0,2))*0.20;
		score -= Double.parseDouble(l.getSmoking().substring(0,2))*0.20;
		return (int)(score + 0.5);
	}



}