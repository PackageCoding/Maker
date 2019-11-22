package backend;

import java.util.Comparator;

public class PowerSupply extends Components {
	private String formFactor;
	private String efficiencyRating;
	private String wattage;
	private String modular;

	public PowerSupply(String name, String formFactor, String efficiencyRating, String wattage, String modular,
			int price, int id) {
		super.setName(name);
		this.formFactor = formFactor;
		this.efficiencyRating = efficiencyRating;
		this.wattage = wattage;
		this.modular = modular;
		super.setPrice(price);
		super.setId(id);
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String getEfficiencyRating() {
		return efficiencyRating;
	}

	public void setEfficiencyRating(String efficiencyRating) {
		this.efficiencyRating = efficiencyRating;
	}

	public String getWattage() {
		return wattage;
	}

	public void setWattage(String wattage) {
		this.wattage = wattage;
	}

	public String getModular() {
		return modular;
	}

	public void setModular(String modular) {
		this.modular = modular;
	}

	public static Comparator<PowerSupply> nameComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			return (p2.getId() > p1.getId() ? -1 : (p2.getId() == p1.getId() ? 0 : 1));
		}
	};

	public static Comparator<PowerSupply> formFactorComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			return (int) (p1.getFormFactor().compareTo(p2.getFormFactor()));
		}
	};

	public static Comparator<PowerSupply> efficiencyRatingComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			return (int) (p1.getEfficiencyRating().compareTo(p2.getEfficiencyRating()));
		}
	};

	public static Comparator<PowerSupply> wattageComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			double t1 = Double.parseDouble(p1.getWattage().replaceAll(" W", ""));
			double t2 = Double.parseDouble(p2.getWattage().replaceAll(" W", ""));
			return (t2 > t1 ? -1 : (t2 == t1 ? 0 : 1));
		}
	};

	public static Comparator<PowerSupply> modularComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			return (int) (p1.getModular().compareTo(p2.getModular()));
		}
	};

	public static Comparator<PowerSupply> priceComparator = new Comparator<PowerSupply>() {
		@Override
		public int compare(PowerSupply p1, PowerSupply p2) {
			return (p2.getPrice() > p1.getPrice() ? -1 : (p2.getPrice() == p1.getPrice() ? 0 : 1));
		}
	};

	@Override
	public String toString() {
		return String.format("%-50s%-10s%-15s%-10s%-5s%-10d%-5d", super.getName(), this.formFactor,
				this.efficiencyRating, this.wattage, this.modular, super.getPrice(), super.getId());
	}

}
