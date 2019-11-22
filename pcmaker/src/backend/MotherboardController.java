package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MotherboardController extends Controller {
	private static MotherboardController instance = null;
	
	private static ArrayList<Motherboard> motherboardList = new ArrayList<>();
	private String[] fieldTitle = new String[8];
	private String[][] tableData;
	
	public static Controller getInstance() {
		if(instance == null) {
			try {
				instance = new MotherboardController();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;	
	}

	private MotherboardController() throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(2);
		boolean firstLine = true;

		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for (int titleNum = 0; titleNum < 8; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				Motherboard motherboard = new Motherboard(row.getCell(0).toString(), row.getCell(1).toString(),
						row.getCell(2).toString(), (int) (Double.parseDouble(row.getCell(3).toString())),
						row.getCell(4).toString(), row.getCell(5).toString(),
						(int) (Double.parseDouble(row.getCell(6).toString())),
						(int) (Double.parseDouble(row.getCell(7).toString())));
				motherboardList.add(motherboard);
			}
		}

		tableData = new String[motherboardList.size()][fieldTitle.length];
		for (int rowNum = 0; rowNum < motherboardList.size(); rowNum++) {
			tableData[rowNum][0] = motherboardList.get(rowNum).getName();
			tableData[rowNum][1] = motherboardList.get(rowNum).getSocket_cpu();
			tableData[rowNum][2] = motherboardList.get(rowNum).getFormFactor();
			tableData[rowNum][3] = Integer.toString(motherboardList.get(rowNum).getRamSlots());
			tableData[rowNum][4] = motherboardList.get(rowNum).getMaxRam();
			tableData[rowNum][5] = motherboardList.get(rowNum).getColor();
			tableData[rowNum][6] = Integer.toString(motherboardList.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(motherboardList.get(rowNum).getId());
		}
	}

	public static Motherboard searchById(int id) {
		for (Motherboard motherboard : motherboardList)
			if (motherboard.getId() == id) {
				System.out.println(motherboard.toString());
				return motherboard;
			}
		return null;
	}

	public static ArrayList<Motherboard> getSortedList(String field, String order) {
		MotherboardSorter motherboardSorter = new MotherboardSorter(motherboardList);
		boolean ascending = true;
		ArrayList<Motherboard> sortedMotherboard = new ArrayList<>();

		if (order == "Descending")
			ascending = false;

//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted Motherboard by " + field + " " + order + ":");
		switch (field) {
			case "Name":
				sortedMotherboard = motherboardSorter.getSortedByName(ascending);
				break;
			case "Socket / CPU":
				sortedMotherboard = motherboardSorter.getSortedBySocket_cpu(ascending);
				break;
			case "Form Factor":
				sortedMotherboard = motherboardSorter.getSortedByFormFactor(ascending);
				break;
			case "RAM Slots":
				sortedMotherboard = motherboardSorter.getSortedByRamSlots(ascending);
				break;
			case "Max RAM":
				sortedMotherboard = motherboardSorter.getSortedByMaxRam(ascending);
				break;
			case "Color":
				sortedMotherboard = motherboardSorter.getSortedByColor(ascending);
				break;
			case "Price":
				sortedMotherboard = motherboardSorter.getSortedByPrice(ascending);
				break;
			default:
				System.out.println("No such field or order!");
				break;
		}

		return sortedMotherboard;
	}
	
	public String[][] getSortedData(String field, String order){
		ArrayList<Motherboard> sortedMotherboard = getSortedList(field, order);
		
		for (int rowNum = 0; rowNum < motherboardList.size(); rowNum++) {
			tableData[rowNum][0] = sortedMotherboard.get(rowNum).getName();
			tableData[rowNum][1] = sortedMotherboard.get(rowNum).getSocket_cpu();
			tableData[rowNum][2] = sortedMotherboard.get(rowNum).getFormFactor();
			tableData[rowNum][3] = Integer.toString(sortedMotherboard.get(rowNum).getRamSlots());
			tableData[rowNum][4] = sortedMotherboard.get(rowNum).getMaxRam();
			tableData[rowNum][5] = sortedMotherboard.get(rowNum).getColor();
			tableData[rowNum][6] = Integer.toString(sortedMotherboard.get(rowNum).getPrice());
			tableData[rowNum][7] = Integer.toString(sortedMotherboard.get(rowNum).getId());
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

	public static Motherboard getRequired(String CPUbrand,int coreCount,int price) {
		ArrayList<Motherboard> sortedMotherboard = getSortedList("Price","Descending");
		for(int rowNum=0; rowNum<sortedMotherboard.size(); rowNum++) {
			if (sortedMotherboard.get(rowNum).getPrice()<=price) {
				if (CPUbrand =="No Preference")
					return searchById(sortedMotherboard.get(rowNum).getId());
				else if (CPUbrand =="Intel") {
					if (coreCount<=4 && sortedMotherboard.get(rowNum).getSocket_cpu().contentEquals("LGA1151"))
						return searchById(sortedMotherboard.get(rowNum).getId());
					else if (coreCount>=6 && sortedMotherboard.get(rowNum).getSocket_cpu().contentEquals("LGA2066"))
						return searchById(sortedMotherboard.get(rowNum).getId());
				}
				else if (CPUbrand =="AMD" && sortedMotherboard.get(rowNum).getSocket_cpu().contentEquals("AM4"))
					return searchById(sortedMotherboard.get(rowNum).getId());
			}
			
		}
		return null;
	}

}
