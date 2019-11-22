package backend;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StorageController extends Controller{
	private static StorageController instance = null;
	
	private static ArrayList<Storage> storageList = new ArrayList<>();

	private String[] fieldTitle = new String[8];
	private String[][] tableData;
	
	public static Controller getInstance() {
		if(instance == null) {
			try {
				instance = new StorageController();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;	
	}
	
	private StorageController() throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(4);
		boolean firstLine = true;

		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for(int titleNum=0; titleNum<8; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				Storage storage = new Storage(row.getCell(0).toString(), row.getCell(1).toString(),
						row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(),
						row.getCell(5).toString(), (int) (Double.parseDouble(row.getCell(6).toString())),
						(int) (Double.parseDouble(row.getCell(7).toString())));
				storageList.add(storage);
			}
		}
		
		tableData = new String[storageList.size()][fieldTitle.length];
		for(int rowNum=0; rowNum<storageList.size(); rowNum++) {
			tableData[rowNum][0] = storageList.get(rowNum).getName();
			tableData[rowNum][1] = storageList.get(rowNum).getCapacity();
			tableData[rowNum][2] = storageList.get(rowNum).getType();
			tableData[rowNum][3] = storageList.get(rowNum).getCache();
			tableData[rowNum][4] = storageList.get(rowNum).getFormFactor();
			tableData[rowNum][5] = storageList.get(rowNum).get_Interface();
			tableData[rowNum][6] = Integer.toString(storageList.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(storageList.get(rowNum).getId());
		}
	}

	public static Storage searchById(int id) {
		for (Storage storage : storageList)
			if (storage.getId() == id) {
				System.out.println(storage.toString());
				return storage;
			}
		return null;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public String[] getFieldTitle() {
		return fieldTitle;
	}


	
	public static ArrayList<Storage> getSortedList(String field, String order) {
		StorageSorter storageSorter = new StorageSorter(storageList);
		boolean ascending = true;
		ArrayList<Storage> sortedStorage = new ArrayList<>();
		
		if (order.equals("Descending"))
			ascending = false;
		
//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted Storage by " + field+ " " + order + ":");
		switch (field) {
			case "Name":
				sortedStorage = storageSorter.getSortedByName(ascending);
				break;
			case "Capacity":
				sortedStorage = storageSorter.getSortedByCapacity(ascending);
				break;
			case "Type":
				sortedStorage = storageSorter.getSortedByType(ascending);
				break;
			case "Cache":
				sortedStorage = storageSorter.getSortedByCache(ascending);
				break;
			case "Form Factor":
				sortedStorage = storageSorter.getSortedByFormFactor(ascending);
				break;
			case "Interface":
				sortedStorage = storageSorter.getSortedBy_Interface(ascending);
				break;
			case "Price":
				sortedStorage = storageSorter.getSortedByPrice(ascending);
				break;
			default:
				System.out.println("No such field or order!");
				break;
		}
		return sortedStorage;
	}
	
	public String[][] getSortedData(String field, String order){
		ArrayList<Storage> sortedStorage = getSortedList(field, order);
		for(int rowNum=0; rowNum<storageList.size(); rowNum++) {
			tableData[rowNum][0] = sortedStorage.get(rowNum).getName();
			tableData[rowNum][1] = sortedStorage.get(rowNum).getCapacity();
			tableData[rowNum][2] = sortedStorage.get(rowNum).getType();
			tableData[rowNum][3] = sortedStorage.get(rowNum).getCache();
			tableData[rowNum][4] = sortedStorage.get(rowNum).getFormFactor();
			tableData[rowNum][5] = sortedStorage.get(rowNum).get_Interface();
			tableData[rowNum][6] = Integer.toString(sortedStorage.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(sortedStorage.get(rowNum).getId());
		}
		return tableData;
	}
	
	public static Storage gerRequired(int price) {
		ArrayList<Storage> sortedStorage = getSortedList("Price","Descending");
		for(int rowNum=0; rowNum<sortedStorage.size(); rowNum++) {
			if (sortedStorage.get(rowNum).getPrice()<=price) {
				return searchById(sortedStorage.get(rowNum).getId());
			}
		}
		return null;
		
	}

}
