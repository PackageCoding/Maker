package backend;

import java.util.Comparator;

public class Storage extends Components {
	private String capacity;
	private String type;
	private String cache;
	private String formFactor;
	private String _interface;

	public Storage(String name, String capacity, String type, String cache, String formFactor, String _interface,
			int price, int id) {
		super.setName(name);
		this.capacity = capacity;
		this.type = type;
		this.cache = cache;
		this.formFactor = formFactor;
		this._interface = _interface;
		super.setPrice(price);
		super.setId(id);
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String get_Interface() {
		return _interface;
	}

	public void set_Interface(String _interface) {
		this._interface = _interface;
	}

	public static Comparator<Storage> nameComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			return (s2.getId() > s1.getId() ? -1 : (s2.getId() == s1.getId() ? 0 : 1));
		}
	};

	public static Comparator<Storage> capacityComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			String[] tokens1 = s1.getCapacity().split(" ");
			String[] tokens2 = s2.getCapacity().split(" ");
			if (!tokens1[1].contentEquals(tokens2[1])) {
				return (int)(tokens1[1].compareTo(tokens2[1]));
			}else {
				int t1 = Integer.parseInt(tokens1[0]);
				int t2 = Integer.parseInt(tokens2[0]);
				return (t2>t1 ? -1 : (t2==t1 ? 0:1));
			}
		}
	};

	public static Comparator<Storage> typeComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			String[] tokens1 = s1.getType().split(" ");
			String[] tokens2 = s2.getType().split(" ");
			try {
				int t1 = Integer.parseInt(tokens1[0]);
				int t2 = Integer.parseInt(tokens2[0]);
				return (t2 > t1 ? -1 : (t2 == t1 ? 0 : 1));
			}
			catch(Exception e) {
				return (int) (s1.getType().compareTo(s2.getType()));
				
			}
		}
	};

	public static Comparator<Storage> cacheComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			int c1 = Integer.parseInt(s1.getCache().replaceAll(" MB", ""));
			int c2 = Integer.parseInt(s2.getCache().replaceAll(" MB", ""));
			return (c2 > c1 ? -1 : (c2 == c1 ? 0 : 1));
		}
	};

	public static Comparator<Storage> formFactorComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			return (int) (s1.getFormFactor().compareTo(s2.getFormFactor()));
		}
	};

	public static Comparator<Storage> _interfaceComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			return (int) (s1.get_Interface().compareTo(s2.get_Interface()));
		}
	};

	public static Comparator<Storage> priceComparator = new Comparator<Storage>() {
		@Override
		public int compare(Storage s1, Storage s2) {
			return (s2.getPrice() > s1.getPrice() ? -1 : (s2.getPrice() == s1.getPrice() ? 0 : 1));
		}
	};

	@Override
	public String toString() {
		return String.format("%-35s%-10s%-10s%-10s%-10s%-15s%-10d%-5d", super.getName(), this.capacity, this.type,
				this.cache, this.formFactor, this._interface, super.getPrice(), super.getId());
	}

}