package backend;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VideoCardController  extends Controller{
	private static ArrayList<VideoCard> videoCardList = new ArrayList<>();
	private String[] fieldTitle = new String[10];
	private String[][] tableData;

	public VideoCardController(XSSFWorkbook workbook) throws IOException {
		XSSFSheet sheet = workbook.getSheetAt(5);
		boolean firstLine = true;

		for (Row row : sheet) {
			if (checkRowEmpty(row)) {
				break;
			} else if (firstLine) {
				for(int titleNum=0; titleNum<10; titleNum++)
					fieldTitle[titleNum] = row.getCell(titleNum).toString();
				firstLine = false;
			} else {
				VideoCard videoCard = new VideoCard(row.getCell(0).toString(), row.getCell(1).toString(),
						row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString(),
						row.getCell(5).toString(), row.getCell(6).toString(),
						(int) (Double.parseDouble(row.getCell(7).toString())),
						(int) (Double.parseDouble(row.getCell(8).toString())),
						row.getCell(9).toString());
				videoCardList.add(videoCard);
			}
		}
		
		tableData = new String[videoCardList.size()][fieldTitle.length];
		for(int rowNum=0; rowNum<videoCardList.size(); rowNum++) {
			tableData[rowNum][0] = videoCardList.get(rowNum).getName();
			tableData[rowNum][1] = videoCardList.get(rowNum).getChipset();
			tableData[rowNum][2] = videoCardList.get(rowNum).getMemory();
			tableData[rowNum][3] = videoCardList.get(rowNum).getCoreClock();
			tableData[rowNum][4] = videoCardList.get(rowNum).getBoostClock();
			tableData[rowNum][5] = videoCardList.get(rowNum).get_Interface();
			tableData[rowNum][6] = videoCardList.get(rowNum).getColor();
			tableData[rowNum][9] = videoCardList.get(rowNum).getTdp(); //added here
			tableData[rowNum][7] = Integer.toString(videoCardList.get(rowNum).getPrice());
			tableData[rowNum][8] = Integer.toString(videoCardList.get(rowNum).getId());
		}
	}

	public static VideoCard searchById(int id) {
		for (VideoCard videoCard : videoCardList)
			if (videoCard.getId() == id) {
				System.out.println(videoCard.toString());
				return videoCard;
			}
		return null;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public String[] getFieldTitle() {
		return fieldTitle;
	}


	public static ArrayList<VideoCard> getSortedList(String field, String order) {
		VideoCardSorter videoCardSorter = new VideoCardSorter(videoCardList);
		boolean ascending = true;
		ArrayList<VideoCard> sortedVideoCard = new ArrayList<>();
		
		if (order.equals("Descending"))
			ascending = false;
//		System.out.println("--------------------------------------------------");
//		System.out.println("Sorted VideoCard by " + field+ " " + order + ":");
		switch (field) {
			case "Name":
				sortedVideoCard = videoCardSorter.getSortedByName(ascending);
				break;
			case "Chipset":
				sortedVideoCard = videoCardSorter.getSortedByChipset(ascending);
				break;
			case "Memory":
				sortedVideoCard = videoCardSorter.getSortedByMemory(ascending);
				break;
			case "Core Clock":
				sortedVideoCard = videoCardSorter.getSortedByCoreClock(ascending);
				break;
			case "Boost Clock":
				sortedVideoCard = videoCardSorter.getSortedByBoostClock(ascending);
				break;
			case "Interface":
				sortedVideoCard = videoCardSorter.getSortedBy_Interface(ascending);
				break;
			case "Color":
				sortedVideoCard = videoCardSorter.getSortedByColor(ascending);
				break;
			case "TDP (W)":
				sortedVideoCard = videoCardSorter.getSortedByTdp(ascending);
				break;
			case "Price":
				sortedVideoCard = videoCardSorter.getSortedByPrice(ascending);
				break;
			default:
				System.out.println("No such field or order!");
				break;
		}
		return sortedVideoCard;
	}
	
	public String[][] getSortedData(String field, String order){
		
		ArrayList<VideoCard> sortedVideoCard = getSortedList(field, order);
		
		for(int rowNum=0; rowNum<videoCardList.size(); rowNum++) {
			tableData[rowNum][0] = sortedVideoCard.get(rowNum).getName();
			tableData[rowNum][1] = sortedVideoCard.get(rowNum).getChipset();
			tableData[rowNum][2] = sortedVideoCard.get(rowNum).getMemory();
			tableData[rowNum][3] = sortedVideoCard.get(rowNum).getCoreClock();
			tableData[rowNum][4] = sortedVideoCard.get(rowNum).getBoostClock();
			tableData[rowNum][5] = sortedVideoCard.get(rowNum).get_Interface();
			tableData[rowNum][6] = sortedVideoCard.get(rowNum).getColor();
			tableData[rowNum][9] = sortedVideoCard.get(rowNum).getTdp();  //here
			tableData[rowNum][7] = Integer.toString(sortedVideoCard.get(rowNum).getPrice());
			tableData[rowNum][8] = Integer.toString(sortedVideoCard.get(rowNum).getId());
		}
		return tableData;
	}
	
	public static VideoCard gerRequired(String VideoCardBrand, int price) {
		ArrayList<VideoCard> sortedVideoCard = getSortedList("Price","Descending");
		System.out.println(VideoCardBrand);
		for(int rowNum=0; rowNum<sortedVideoCard.size(); rowNum++) {
			if (sortedVideoCard.get(rowNum).getPrice()<=price) {
				if (VideoCardBrand =="No Preference")
					return searchById(sortedVideoCard.get(rowNum).getId());
				else if (VideoCardBrand.contentEquals("NVidia") && sortedVideoCard.get(rowNum).getChipset().contains("GeForce")) {
					return searchById(sortedVideoCard.get(rowNum).getId());
				}
				else if (VideoCardBrand.contentEquals("AMD") && sortedVideoCard.get(rowNum).getChipset().contains("Radeon"))
					return searchById(sortedVideoCard.get(rowNum).getId());
			}
			
		}
		return null;
	}
	
	
}