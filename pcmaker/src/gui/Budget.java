package gui;

import javax.swing.JPanel;

public class Budget {
	private int total, cpuPrice, mbPrice, ramPrice, psuPrice, videoCardPrice, storagePrice;
	private Boolean preferAmdCPU, preferAmdCard;
	private TotalObserver observer;
	
	/*public boolean reachTotal(int newValue) {
		int sum = cpuPrice + mbPrice + ramPrice + psuPrice + newValue;
		if(sum>total)
			return true;
		
		return false;
	}
	
	public int getRemaining() {
		int remain = total - cpuPrice - mbPrice - ramPrice - psuPrice;
		if(remain>0) 
			return remain;
		return 0;
	}*/
	
	public Budget(TotalObserver observer) {
		this.observer = observer;
		resetComponentToZero();
		preferAmdCPU = null;
		preferAmdCard = null;
	}
	
	
	public void resetComponentToZero() {
		this.total = 0;
		this.cpuPrice = 0;
		this.mbPrice = 0;
		this.ramPrice = 0;
		this.psuPrice = 0;
		this.videoCardPrice = 0;
		this.storagePrice = 0;
		
		//observer.updateTotal();
	}
	
	public void showTotal() {
		System.out.println("------------------");
		System.out.println(total);
		System.out.println(cpuPrice);
		System.out.println(mbPrice);
		System.out.println(ramPrice);
		System.out.println(videoCardPrice);
		System.out.println(psuPrice);
		System.out.println(storagePrice);
		System.out.println(preferAmdCPU);
		System.out.println(preferAmdCard);
		System.out.println("------------------");
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void addTotal(int increment) {
		this.total += increment;
		observer.updateTotal();
	}

	public int getCpuPrice() {
		return cpuPrice;
	}

	public void addCpuPrice(int increment) {
		this.cpuPrice += increment;
		addTotal(increment);;
	}

	public int getMbPrice() {
		return mbPrice;
	}

	public void addMbPrice(int increment) {
		this.mbPrice += increment;
		addTotal(increment);
	}

	public int getRamPrice() {
		return ramPrice;
	}

	public void addRamPrice(int increment) {
		this.ramPrice += increment;
		addTotal(increment);
	}

	public int getPsuPrice() {
		return psuPrice;
	}

	public void addPsuPrice(int increment) {
		this.psuPrice += increment;
		addTotal(increment);
	}
	
	public int getVideoCardPrice() {
		return videoCardPrice;
	}

	public void addVideoCardPrice(int increment) {
		this.videoCardPrice += increment;
		addTotal(increment);
	}
	
	public int getStoragePrice() {
		return storagePrice;
	}

	public void addStoragePrice(int increment) {
		this.storagePrice += increment;
		addTotal(increment);
	}
	
	public void setCPUPreference(String brand) {
		switch(brand) {
		case "Intel":
			preferAmdCPU = false;
			break;
		case "AMD":
			preferAmdCPU = true;
			break;
		default:
			preferAmdCPU = null;
		}
	}
	
	public void setCardPreference(String brand) {
		switch(brand) {
		case "NVidia":
			preferAmdCard = false;
			break;
		case "AMD":
			preferAmdCard = true;
			break;
		default:
			preferAmdCard = null;
		}
	}
	
	
}
