package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CPUController extends Controller{
	private static ArrayList<CPU> cpuList = new ArrayList<>();
	private String[] fieldTitle = new String[9];
	private String[][] tableData;

	public CPUController(XSSFWorkbook workbook) throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(0);
		boolean firstLine = true;
	
		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for(int titleNum=0; titleNum<9; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				CPU cpu = new CPU(row.getCell(0).toString(), (int) (Double.parseDouble(row.getCell(1).toString())),
						row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(),
						row.getCell(5).toString(), row.getCell(6).toString(),
						(int) (Double.parseDouble(row.getCell(7).toString())),
						(int) (Double.parseDouble(row.getCell(8).toString())));
				cpuList.add(cpu);
			}
		}
		//System.out.println(cpuList.size());
		
		tableData = new String[cpuList.size()][fieldTitle.length];
		for(int rowNum=0; rowNum<cpuList.size(); rowNum++) {
			tableData[rowNum][0] = cpuList.get(rowNum).getName();
			tableData[rowNum][1] = Integer.toString(cpuList.get(rowNum).getCoreCount());
			tableData[rowNum][2] = cpuList.get(rowNum).getCoreClock();
			tableData[rowNum][3] = cpuList.get(rowNum).getBoostClock();
			tableData[rowNum][4] = cpuList.get(rowNum).getTdp();
			tableData[rowNum][5] = cpuList.get(rowNum).getIntegratedGraphics();
			tableData[rowNum][6] = cpuList.get(rowNum).getSmt();
			tableData[rowNum][7] = Integer.toString(cpuList.get(rowNum).getPrice());
			tableData[rowNum][8] = Integer.toString(cpuList.get(rowNum).getId());
		}
	}

	public static CPU searchById(int id) {
		for (CPU cpu : cpuList)
			if (cpu.getId() == id) {
				System.out.println(cpu.toString());
				return cpu;
			}
		return null;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public String[] getFieldTitle() {
		return fieldTitle;
	}
	
	public static ArrayList<CPU> getSortedList(String field, String order) {
		CPUSorter cpuSorter = new CPUSorter(cpuList);
		boolean ascending = true;
		ArrayList<CPU> sortedCPU = new ArrayList<>();
		
		if (order.equals("Descending"))
			ascending = false;
		
//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted CPU by " + field + " " + order + ":");
		switch (field) {
			case "Name":
				sortedCPU = cpuSorter.getSortedByName(ascending);
				break;
			case "Core Count":
				sortedCPU = cpuSorter.getSortedByCoreCount(ascending);
				break;
			case "Core Clock":
				sortedCPU = cpuSorter.getSortedByCoreClock(ascending);
				break;
			case "Boost Clock":
				sortedCPU = cpuSorter.getSortedByCoreClock(ascending);
				break;
			case "TDP":
				sortedCPU = cpuSorter.getSortedByTdp(ascending);
				break;
			case "Integrated Graphics":
				sortedCPU = cpuSorter.getSortedByIntegratedGraphics(ascending);
				break;
			case "SMT":
				sortedCPU = cpuSorter.getSortedBySmt(ascending);
				break;
			case "Price":
				sortedCPU = cpuSorter.getSortedByPrice(ascending);
				break;
			default:
				System.out.println("No such field or order!");
				break;
		}
		
		return sortedCPU;
	}

	public String[][] getSortedData(String field, String order){
		
		ArrayList<CPU> sortedCPU = getSortedList(field, order);
		
		for(int rowNum=0; rowNum<cpuList.size(); rowNum++) {
			tableData[rowNum][0] = sortedCPU.get(rowNum).getName();
			tableData[rowNum][1] = Integer.toString(sortedCPU.get(rowNum).getCoreCount());
			tableData[rowNum][2] = sortedCPU.get(rowNum).getCoreClock();
			tableData[rowNum][3] = sortedCPU.get(rowNum).getBoostClock();
			tableData[rowNum][4] = sortedCPU.get(rowNum).getTdp();
			tableData[rowNum][5] = sortedCPU.get(rowNum).getIntegratedGraphics();
			tableData[rowNum][6] = sortedCPU.get(rowNum).getSmt();
			tableData[rowNum][7] = Integer.toString(sortedCPU.get(rowNum).getPrice());
			tableData[rowNum][8] = Integer.toString(sortedCPU.get(rowNum).getId());
		}
		
		return tableData;
	}
	
	public static CPU getRequired(String CPUbrand,int price) {
		ArrayList<CPU> sortedCPU = getSortedList("Price","Descending");
		for(int rowNum=0; rowNum<sortedCPU.size(); rowNum++) {
			if (CPUbrand =="No Preference" && sortedCPU.get(rowNum).getPrice()<=price) {
				return searchById(sortedCPU.get(rowNum).getId());
			}
			else if (sortedCPU.get(rowNum).getPrice()<=price && sortedCPU.get(rowNum).getName().charAt(0)==CPUbrand.charAt(0))
				return searchById(sortedCPU.get(rowNum).getId());
		}
		return null;
	}
	
}
