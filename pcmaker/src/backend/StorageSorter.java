package backend;

import java.util.ArrayList;
import java.util.Collections;

public class StorageSorter {
	private ArrayList<Storage> storage = new ArrayList<>();

	public StorageSorter(ArrayList<Storage> storage) {
		this.storage = storage;
	}

	public ArrayList<Storage> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.nameComparator);
		else
			Collections.sort(storage, Storage.nameComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedByCapacity(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.capacityComparator);
		else
			Collections.sort(storage, Storage.capacityComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedByType(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.typeComparator);
		else 
			Collections.sort(storage, Storage.typeComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedByCache(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.cacheComparator);
		else
			Collections.sort(storage, Storage.cacheComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedByFormFactor(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.formFactorComparator);
		else
			Collections.sort(storage, Storage.formFactorComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedBy_Interface(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage._interfaceComparator);
		else
			Collections.sort(storage, Storage._interfaceComparator.reversed());
		return storage;
	}

	public ArrayList<Storage> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(storage, Storage.priceComparator);
		else
			Collections.sort(storage, Storage.priceComparator.reversed());
		return storage;
	}

}
