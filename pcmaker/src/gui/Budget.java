package gui;

public class Budget {
	private int total, cpuPrice, mbPrice, ramPrice, psuPrice, videoCardPrice, storagePrice;
	private String preferCPU, preferVideoCard;
	private TotalObserver observer;
	
	public Budget(TotalObserver observer) {
		this.observer = observer;
		resetComponentToZero();
		preferCPU = "Null";
		preferVideoCard = "Null";
	}
	
	public void resetComponentToZero() {
		this.total = 0;
		this.cpuPrice = 0;
		this.mbPrice = 0;
		this.ramPrice = 0;
		this.psuPrice = 0;
		this.videoCardPrice = 0;
		this.storagePrice = 0;
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
		preferCPU = brand;
	}
	
	public String getCPUPreference() {
		return preferCPU;
	}
	
	public void setCardPreference(String brand) {
		preferVideoCard = brand;
	}
	
	public String getCardPreference() {
		return preferVideoCard;
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
		System.out.println(preferCPU);
		System.out.println(preferVideoCard);
		System.out.println("------------------");
	}

}
