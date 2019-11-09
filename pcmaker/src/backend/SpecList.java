package backend;

import java.io.File.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gui.Budget;
import gui.Sub_Budget;

public class SpecList {
	private Budget budget;
	private CPU cpu;
	private Motherboard montherboard;
	private Memory memory;
	private Storage storage;
	private VideoCard videoCard;
	private PowerSupply powerSupply;
	private PowerSupplyController powerSupplyController;

	public SpecList(Budget budget)  {
		this.budget = budget;
	}

	public void print() {
		this.cpu = CPUController.getRequired(budget.getCPUPreference(),budget.getCpuPrice());
		if (cpu==null) {
			System.out.println("No CPU model can fulfill your requirment!");
			return;
		}else{
			this.montherboard = MotherboardController.getRequired(budget.getCPUPreference(),this.cpu.getCoreCount(),budget.getMbPrice());
			this.memory = MemoryController.gerRequired(budget.getRamPrice());
			this.storage = StorageController.gerRequired(budget.getStoragePrice());
			this.videoCard = VideoCardController.gerRequired(budget.getCardPreference(), budget.getVideoCardPrice());
		}
		
		if (montherboard==null || memory==null || storage==null || videoCard==null)
			System.out.println("No result found!");
		else {
			double power;
			power = Double.parseDouble(cpu.getTdp()) + Double.parseDouble(videoCard.getTdp());
			this.powerSupply = PowerSupplyController.gerRequired(power,budget.getPsuPrice());
			System.out.println("Hello, here is your specification list with follwoing limitation: \n1: CPU Brand Preference: "+ budget.getCPUPreference() + "\n2: Video Card Brand Preference: "+ budget.getCardPreference() + "\n3. Total input cost: $" + budget.getTotal());
			System.out.println("Our suggesttion will be:");
			System.out.println("\nCpu: " + cpu.getName() +", Price: $" + cpu.getPrice());
			System.out.println("\nMontherboard: " + montherboard.getName() +", Price: $" + montherboard.getPrice());
			System.out.println("\nMemory: " + memory.getName() +", Price: $" + memory.getPrice());
			System.out.println("\nStorage: " + storage.getName() +", Price: $" + storage.getPrice());
			System.out.println("\nVideoCard: " + videoCard.getName() +", Price: $" + videoCard.getPrice());
			System.out.println("\nPowerSupply: " + powerSupply.getName() +", Price: $" + powerSupply.getPrice());
			int totalcost = cpu.getPrice() + montherboard.getPrice() + memory.getPrice() + storage.getPrice() + videoCard.getPrice() + powerSupply.getPrice();
			System.out.println("\nTotal Cost:$" + totalcost) ;
		}
	}

}
