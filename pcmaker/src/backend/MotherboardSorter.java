package backend;

import java.util.ArrayList;
import java.util.Collections;

public class MotherboardSorter {
	private ArrayList<Motherboard> motherboard = new ArrayList<>();

	public MotherboardSorter(ArrayList<Motherboard> motherboard) {
		this.motherboard = motherboard;
	}

	public ArrayList<Motherboard> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.nameComparator);
		else
			Collections.sort(motherboard, Motherboard.nameComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedBySocket_cpu(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.socket_cpuComparator);
		else
			Collections.sort(motherboard, Motherboard.socket_cpuComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedByFormFactor(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.formFactorComparator);
		else
			Collections.sort(motherboard, Motherboard.formFactorComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedByRamSlots(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.ramSlotsComparator);
		else
			Collections.sort(motherboard, Motherboard.ramSlotsComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedByMaxRam(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.maxRamComparator);
		else
			Collections.sort(motherboard, Motherboard.maxRamComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedByColor(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.colorComparator);
		else
			Collections.sort(motherboard, Motherboard.colorComparator.reversed());
		return motherboard;
	}

	public ArrayList<Motherboard> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(motherboard, Motherboard.priceComparator);
		else
			Collections.sort(motherboard, Motherboard.priceComparator.reversed());
		return motherboard;
	}

}
