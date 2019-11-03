package gui;
public class Budget {
	private int total = 0, cpuPrice = 0, mbPrice = 0, ramPrice = 0, psuPrice = 0;
	
	public boolean reachTotal(int newValue) {
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
	}
	
	public void resetComponentToZero() {
		this.cpuPrice = 0;
		this.mbPrice = 0;
		this.ramPrice = 0;
		this.psuPrice = 0;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}

	public int getCpuPrice() {
		return cpuPrice;
	}

	public void addCpuPrice(int increment) {
		this.cpuPrice += increment;
	}

	public int getMbPrice() {
		return mbPrice;
	}

	public void addMbPrice(int increment) {
		this.mbPrice += increment;
	}

	public int getRamPrice() {
		return ramPrice;
	}

	public void addRamPrice(int increment) {
		this.ramPrice += increment;
	}

	public int getPsuPrice() {
		return psuPrice;
	}

	public void addPsuPrice(int increment) {
		this.psuPrice += increment;
	}
	
}
