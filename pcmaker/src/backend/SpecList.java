package backend;

import java.io.File.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gui.Budget;
//import gui.Sub_Budget;

public class SpecList {
	private Budget budget;
	private CPU cpu;
	private Motherboard montherboard;
	private Memory memory;
	private Storage storage;
	private VideoCard videoCard;
	private PowerSupply powerSupply;
	private PowerSupplyController powerSupplyController;
	
	private String cpuMessage;
	private String motherboardMessage;
	private String memoryMessage;
	private String videoCardMessage;
	private String storageMessage;
	private String powerSupplyMessage;
	private String totalMessage;
	

	public SpecList(Budget budget)  {
		this.budget = budget;
		
	}

	public boolean findList() {
		this.cpu = CPUController.getRequired(budget.getCPUPreference(),budget.getCpuPrice());
		if (cpu==null) {
			System.out.println("No CPU model can fulfill your requirment!");
			return false;
		}else{
			this.montherboard = MotherboardController.getRequired(budget.getCPUPreference(),this.cpu.getCoreCount(),budget.getMbPrice());
			this.memory = MemoryController.gerRequired(budget.getRamPrice());
			this.storage = StorageController.gerRequired(budget.getStoragePrice());
			this.videoCard = VideoCardController.gerRequired(budget.getCardPreference(), budget.getVideoCardPrice());
		}
		
		if (montherboard==null || memory==null || storage==null || videoCard==null) {
			System.out.println("No result found !");
			return false;
		}
		else {
			double power;
			power = Double.parseDouble(cpu.getTdp()) + Double.parseDouble(videoCard.getTdp());
			this.powerSupply = PowerSupplyController.gerRequired(power,budget.getPsuPrice());
//			System.out.println("Hello, here is your specification list with follwoing limitation: \n1: CPU Brand Preference: "+ budget.getCPUPreference() + "\n2: Video Card Brand Preference: "+ budget.getCardPreference() + "\n3. Total input cost: $" + budget.getTotal());
//			System.out.println("Our suggesttion will be:");
			cpuMessage = "Cpu: " + cpu.getName() +", Price: $" + cpu.getPrice();
			motherboardMessage = "Montherboard: " + montherboard.getName() +", Price: $" + montherboard.getPrice();
			memoryMessage = "Memory: " + memory.getName() +", Price: $" + memory.getPrice();
			storageMessage = "Storage: " + storage.getName() +", Price: $" + storage.getPrice();
			videoCardMessage = "VideoCard: " + videoCard.getName() +", Price: $" + videoCard.getPrice();
			powerSupplyMessage = "PowerSupply: " + powerSupply.getName() +", Price: $" + powerSupply.getPrice();
			int totalcost = cpu.getPrice() + montherboard.getPrice() + memory.getPrice() + storage.getPrice() + videoCard.getPrice() + powerSupply.getPrice();
			totalMessage = "Total Cost:$" + totalcost;
			
			return true;
		}
	}

	public String getCpuMessage() {
		return cpuMessage;
	}

	public String getMotherboardMessage() {
		return motherboardMessage;
	}

	public String getMemoryMessage() {
		return memoryMessage;
	}

	public String getStorageMessage() {
		return storageMessage;
	}

	public String getVideoCardMessage() {
		return videoCardMessage;
	}

	public String getPowerSupplyMessage() {
		return powerSupplyMessage;
	}

	public String getTotalMessage() {
		return totalMessage;
	}

}
