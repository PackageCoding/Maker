package backend;

import java.util.ArrayList;
import java.util.Collections;

public class MemorySorter {
	private ArrayList<Memory> memory = new ArrayList<>();

	public MemorySorter(ArrayList<Memory> memory) {
		this.memory = memory;
	}

	public ArrayList<Memory> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.nameComparator);
		else
			Collections.sort(memory, Memory.nameComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedBySpeed(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.speedComparator);
		else
			Collections.sort(memory, Memory.speedComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedByType(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.typeComparator);
		else
			Collections.sort(memory, Memory.typeComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedByModules(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.modulesComparator);
		else
			Collections.sort(memory, Memory.modulesComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedByColor(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.colorComparator);
		else
			Collections.sort(memory, Memory.colorComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedByCasLatency(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.casLatencyComparator);
		else
			Collections.sort(memory, Memory.casLatencyComparator.reversed());
		return memory;
	}

	public ArrayList<Memory> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(memory, Memory.priceComparator);
		else
			Collections.sort(memory, Memory.priceComparator.reversed());
		return memory;
	}

}
