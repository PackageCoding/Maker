package backend;

import java.util.ArrayList;
import java.util.Collections;

public class CPUSorter {
	private ArrayList<CPU> cpu = new ArrayList<>();

	public CPUSorter(ArrayList<CPU> cpu) {
		this.cpu = cpu;
	}

	public ArrayList<CPU> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.nameComparator);
		else
			Collections.sort(cpu, CPU.nameComparator.reversed());
		return cpu;
	}

	public ArrayList<CPU> getSortedByCoreCount(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.coreCountComparator);
		else
			Collections.sort(cpu, CPU.coreCountComparator.reversed());
		return cpu;
	}


	public ArrayList<CPU> getSortedByCoreClock(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.coreClockComparator);
		else 
			Collections.sort(cpu, CPU.coreClockComparator.reversed());
		return cpu;
	}


	public ArrayList<CPU> getSortedByBoostClock(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.boostClockComparator);
		else
			Collections.sort(cpu, CPU.boostClockComparator.reversed());
		return cpu;
	}


	public ArrayList<CPU> getSortedByTdp(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.tdpComparator);
		else
			Collections.sort(cpu, CPU.tdpComparator.reversed());
		return cpu;
	}


	public ArrayList<CPU> getSortedByIntegratedGraphics(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.integratedGraphicsComparator);
		else
			Collections.sort(cpu, CPU.integratedGraphicsComparator.reversed());
		return cpu;
	}


	public ArrayList<CPU> getSortedBySmt(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.smtComparator);
		else
			Collections.sort(cpu, CPU.smtComparator.reversed());
		return cpu;
	}

	public ArrayList<CPU> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(cpu, CPU.priceComparator);
		else
			Collections.sort(cpu, CPU.priceComparator.reversed());
		return cpu;
	}
	

}
