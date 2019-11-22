package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PowerSupplyController extends Controller {
	private static PowerSupplyController instance = null;
	
	private static ArrayList<PowerSupply> powerSupplyList = new ArrayList<>();

	private String[] fieldTitle = new String[7];
	private String[][] tableData;
	
	public static Controller getInstance() {
		if(instance == null) {
			try {
				instance = new PowerSupplyController();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;	
	}

	private PowerSupplyController() throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(3);
		boolean firstLine = true;

		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for (int titleNum = 0; titleNum < 7; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				PowerSupply powerSupply = new PowerSupply(row.getCell(0).toString(), row.getCell(1).toString(),
						row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(),
						(int) (Double.parseDouble(row.getCell(5).toString())),
						(int) (Double.parseDouble(row.getCell(6).toString())));
				powerSupplyList.add(powerSupply);
			}
		}

		tableData = new String[powerSupplyList.size()][fieldTitle.length];
		for (int rowNum = 0; rowNum < powerSupplyList.size(); rowNum++) {
			tableData[rowNum][0] = powerSupplyList.get(rowNum).getName();
			tableData[rowNum][1] = powerSupplyList.get(rowNum).getFormFactor();
			tableData[rowNum][2] = powerSupplyList.get(rowNum).getEfficiencyRating();
			tableData[rowNum][3] = powerSupplyList.get(rowNum).getWattage();
			tableData[rowNum][4] = powerSupplyList.get(rowNum).getModular();
			tableData[rowNum][5] = Integer.toString(powerSupplyList.get(rowNum).getPrice());
			tableData[rowNum][6] = Integer.toString(powerSupplyList.get(rowNum).getId());
		}
	}

	public static PowerSupply searchById(int id) {
		for (PowerSupply powerSupply : powerSupplyList)
			if (powerSupply.getId() == id) {
				System.out.println(powerSupply.toString());
				return powerSupply;
			}
		return null;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public String[] getFieldTitle() {
		return fieldTitle;
	}


	public static ArrayList<PowerSupply> getSortedList(String field, String order) {
		PowerSupplySorter powerSupplySorter = new PowerSupplySorter(powerSupplyList);
		boolean ascending = true;
		ArrayList<PowerSupply> sortedPowerSupply = new ArrayList<>();

		if (order.equals("Descending"))
			ascending = false;

//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted PowerSupply by " + field + " " + order + ":");
		switch (field) {
		case "Name":
			sortedPowerSupply = powerSupplySorter.getSortedByName(ascending);
			break;
		case "Form Factor":
			sortedPowerSupply = powerSupplySorter.getSortedByFormFactor(ascending);
			break;
		case "Efficiency Rating":
			sortedPowerSupply = powerSupplySorter.getSortedByEfficiencyRating(ascending);
			break;
		case "Wattage":
			sortedPowerSupply = powerSupplySorter.getSortedByWattage(ascending);
			break;
		case "Modular":
			sortedPowerSupply = powerSupplySorter.getSortedByModular(ascending);
			break;
		case "Price":
			sortedPowerSupply = powerSupplySorter.getSortedByPrice(ascending);
			break;
		default:
			System.out.println("No such field or order!");
			break;
		}

		return sortedPowerSupply;
	}


	public String[][] getSortedData(String field, String order){
		
		ArrayList<PowerSupply> sortedPowerSupply = getSortedList(field, order);
		
		for (int rowNum = 0; rowNum < powerSupplyList.size(); rowNum++) {
			tableData[rowNum][0] = sortedPowerSupply.get(rowNum).getName();
			tableData[rowNum][1] = sortedPowerSupply.get(rowNum).getFormFactor();
			tableData[rowNum][2] = sortedPowerSupply.get(rowNum).getEfficiencyRating();
			tableData[rowNum][3] = sortedPowerSupply.get(rowNum).getWattage();
			tableData[rowNum][4] = sortedPowerSupply.get(rowNum).getModular();
			tableData[rowNum][5] = Integer.toString(sortedPowerSupply.get(rowNum).getPrice());
			tableData[rowNum][6] = Integer.toString(sortedPowerSupply.get(rowNum).getId());
		}

		return tableData;
	}
	
	public static PowerSupply gerRequired(double power, int price) {
		ArrayList<PowerSupply> sortedPowerSupply = getSortedList("Price","Descending");
		for(int rowNum=0; rowNum<sortedPowerSupply.size(); rowNum++) {
			if (sortedPowerSupply.get(rowNum).getPrice()<=price && Double.parseDouble(sortedPowerSupply.get(rowNum).getWattage())>=power) {
				return searchById(sortedPowerSupply.get(rowNum).getId());
			}
		}
		return null;
	}

}
