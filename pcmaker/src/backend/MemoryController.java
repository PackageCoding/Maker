package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MemoryController extends Controller{
	private static MemoryController instance = null;
	
	private static ArrayList<Memory> memoryList = new ArrayList<>();
	private String[] fieldTitle = new String[8];
	private String[][] tableData;
	
	public static Controller getInstance() {
		if(instance == null) {
			try {
				instance = new MemoryController();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;	
	}
	
	private MemoryController() throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(1);
		boolean firstLine = true;
		
		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for(int titleNum=0; titleNum<8; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				Memory memory = new Memory(row.getCell(0).toString(), row.getCell(1).toString(),
						row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(),
						(int) (Double.parseDouble(row.getCell(5).toString())),
						(int) (Double.parseDouble(row.getCell(6).toString())),
						(int) (Double.parseDouble(row.getCell(7).toString())));
				memoryList.add(memory);
			}
		}

		tableData = new String[memoryList.size()][fieldTitle.length];
		for(int rowNum=0; rowNum<memoryList.size(); rowNum++) {
			tableData[rowNum][0] = memoryList.get(rowNum).getName();
			tableData[rowNum][1] = memoryList.get(rowNum).getSpeed();
			tableData[rowNum][2] = memoryList.get(rowNum).getType();
			tableData[rowNum][3] = memoryList.get(rowNum).getModules();
			tableData[rowNum][4] = memoryList.get(rowNum).getColor();
			tableData[rowNum][5] = Integer.toString(memoryList.get(rowNum).getCasLatency());
			tableData[rowNum][6] = Integer.toString(memoryList.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(memoryList.get(rowNum).getId());
		}
	}

	public static Memory searchById(int id) {
		for (Memory memory : memoryList)
			if (memory.getId() == id) {
				System.out.println(memory.toString());
				return memory;
			}
		return null;
	}

	public static ArrayList<Memory> getSortedList(String field, String order) {
		MemorySorter memorySorter = new MemorySorter(memoryList);
		boolean ascending = true;
		ArrayList<Memory> sortedMemory = new ArrayList<>();

		if (order.equals("Descending"))
			ascending = false;

//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted Memory by " + field + " " + order + ":");
		switch (field) {
		case "Name":
			sortedMemory = memorySorter.getSortedByName(ascending);
			break;
		case "Speed":
			sortedMemory = memorySorter.getSortedBySpeed(ascending);
			break;
		case "Type":
			sortedMemory = memorySorter.getSortedByType(ascending);
			break;
		case "Modules":
			sortedMemory = memorySorter.getSortedByModules(ascending);
			break;
		case "Color":
			sortedMemory = memorySorter.getSortedByColor(ascending);
			break;
		case "CAS Latency":
			sortedMemory = memorySorter.getSortedByCasLatency(ascending);
			break;
		case "Price":
			sortedMemory = memorySorter.getSortedByPrice(ascending);
			break;
		default:
			System.out.println("No such field or order!");
			break;
		}
		return sortedMemory;
	}
	
	public String[][] getSortedData(String field, String order){
		ArrayList<Memory> sortedMemory = getSortedList(field, order);
		for(int rowNum=0; rowNum<memoryList.size(); rowNum++) {
			tableData[rowNum][0] = sortedMemory.get(rowNum).getName();
			tableData[rowNum][1] = sortedMemory.get(rowNum).getSpeed();
			tableData[rowNum][2] = sortedMemory.get(rowNum).getType();
			tableData[rowNum][3] = sortedMemory.get(rowNum).getModules();
			tableData[rowNum][4] = sortedMemory.get(rowNum).getColor();
			tableData[rowNum][5] = Integer.toString(sortedMemory.get(rowNum).getCasLatency());
			tableData[rowNum][6] = Integer.toString(sortedMemory.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(sortedMemory.get(rowNum).getId());
		}

		return tableData;
	}

	@Override
	public String[] getFieldTitle() {
		return fieldTitle;
	}

	@Override
	public String[][] getTableData() {
		return tableData;
	}
	
	public static Memory gerRequired(int price) {
		ArrayList<Memory> sortedMemory = getSortedList("Price","Descending");
		for(int rowNum=0; rowNum<memoryList.size(); rowNum++) {
			if (sortedMemory.get(rowNum).getPrice()<=price) {
				return searchById(sortedMemory.get(rowNum).getId());
			}
		}
		return null;
		
	}

}
