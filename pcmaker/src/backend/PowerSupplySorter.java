package backend;

import java.util.ArrayList;
import java.util.Collections;

public class PowerSupplySorter {
	private ArrayList<PowerSupply> powerSupply = new ArrayList<>();

	public PowerSupplySorter(ArrayList<PowerSupply> powerSupply) {
		this.powerSupply = powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.nameComparator);
		else
			Collections.sort(powerSupply, PowerSupply.nameComparator.reversed());
		return powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByFormFactor(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.formFactorComparator);
		else
			Collections.sort(powerSupply, PowerSupply.formFactorComparator.reversed());
		return powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByEfficiencyRating(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.efficiencyRatingComparator);
		else
			Collections.sort(powerSupply, PowerSupply.efficiencyRatingComparator.reversed());
		return powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByWattage(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.wattageComparator);
		else
			Collections.sort(powerSupply, PowerSupply.wattageComparator.reversed());
		return powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByModular(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.modularComparator);
		else
			Collections.sort(powerSupply, PowerSupply.modularComparator.reversed());
		return powerSupply;
	}

	public ArrayList<PowerSupply> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(powerSupply, PowerSupply.priceComparator);
		else
			Collections.sort(powerSupply, PowerSupply.priceComparator.reversed());
		return powerSupply;
	}

}
