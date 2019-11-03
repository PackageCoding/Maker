package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MotherboardController extends Controller {
	private ArrayList<Motherboard> motherboardList = new ArrayList<>();
	private String[] fieldTitle = new String[8];
	private String[][] tableData;

	public MotherboardController(XSSFWorkbook workbook) throws IOException {
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

	public Motherboard searchById(int id) {
		for (Motherboard motherboard : motherboardList)
			if (motherboard.getId() == id) {
				System.out.println(motherboard.toString());
				return motherboard;
			}
		return null;
	}

	@Override
	public String[][] getSortedData(String field, String order) {
		MotherboardSorter motherboardSorter = new MotherboardSorter(motherboardList);
		boolean ascending = true;
		ArrayList<Motherboard> sortedMotherboard = new ArrayList<>();

		if (order == "Descending")
			ascending = false;

		System.out.println("--------------------------------------------------");
		System.out.println("Sorted Motherboard by " + field + " " + order + ":");
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
}
