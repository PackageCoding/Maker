package backend;

import java.util.Comparator;

public class Memory extends Components {
	private String speed;
	private String type;
	private String modules;
	private String color;
	private int casLatency;

	public Memory(String name, String speed, String type, String modules, String color, int casLatency, int price, int id) {
		super.setName(name);
		this.speed = speed;
		this.type = type;
		this.modules = modules;
		this.color = color;
		this.casLatency = casLatency;
		super.setPrice(price);
		super.setId(id);
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCasLatency() {
		return casLatency;
	}

	public void setCasLatency(int casLatency) {
		this.casLatency = casLatency;
	}

	public static Comparator<Memory> nameComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (m2.getId() > m1.getId() ? -1 : (m2.getId() == m1.getId() ? 0 : 1));
		}
	};

	public static Comparator<Memory> speedComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (int) (m1.getSpeed().compareTo(m2.getSpeed()));
		}
	};

	public static Comparator<Memory> typeComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (int) (m1.getType().compareTo(m2.getType()));
		}
	};

	public static Comparator<Memory> modulesComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {

			int mo1 = Integer.parseInt(m1.getModules().substring(0, m1.getModules().indexOf(" ")));
			int mo2 = Integer.parseInt(m2.getModules().substring(0, m2.getModules().indexOf(" ")));
			String[] tokens1 = (m1.getModules().replaceAll("GB", "")).split(" x ");
			String[] tokens2 = (m2.getModules().replaceAll("GB", "")).split(" x ");
			int total1 = Integer.parseInt(tokens1[1])* mo1;
			int total2 = Integer.parseInt(tokens2[1])* mo2;
			return total1 < total2? -1 : total1 == total2 ? 0:1;
		}
	};

	public static Comparator<Memory> colorComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (int) (m1.getColor().compareTo(m2.getColor()));
		}
	};

	public static Comparator<Memory> casLatencyComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (m2.getCasLatency() > m1.getCasLatency() ? -1 : (m2.getCasLatency() == m1.getCasLatency() ? 0 : 1));
		}
	};

	public static Comparator<Memory> priceComparator = new Comparator<Memory>() {
		@Override
		public int compare(Memory m1, Memory m2) {
			return (m2.getPrice() > m1.getPrice() ? -1 : (m2.getPrice() == m1.getPrice() ? 0 : 1));
		}
	};

	@Override
	public String toString() {
		return String.format("%-45s%-15s%-15s%-10s%-20s%-10d%-10d%-5d", super.getName(), this.speed, this.type,
				this.modules, this.color, this.casLatency, super.getPrice(), super.getId());
	}

}