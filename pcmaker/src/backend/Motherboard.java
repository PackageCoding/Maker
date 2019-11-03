package backend;

import java.util.Comparator;

public class Motherboard extends Components {
	private String socket_cpu;
	private String formFactor;
	private int ramSlots;
	private String maxRam;
	private String color;

	public Motherboard(String name, String socket_cpu, String formFactor, int ramSlots, String maxRam, String color,
			int price, int id) {
		super.setName(name);
		this.socket_cpu = socket_cpu;
		this.formFactor = formFactor;
		this.ramSlots = ramSlots;
		this.maxRam = maxRam;
		this.color = color;
		super.setPrice(price);
		super.setId(id);
	}

	public String getSocket_cpu() {
		return this.socket_cpu;
	}

	public String getFormFactor() {
		return this.formFactor;
	}

	public int getRamSlots() {
		return this.ramSlots;
	}

	public String getMaxRam() {
		return this.maxRam;
	}

	public String getColor() {
		return this.color;
	}

	public static Comparator<Motherboard> nameComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (m2.getId() > m1.getId() ? -1 : (m2.getId() == m1.getId() ? 0 : 1));
		}
	};

	public static Comparator<Motherboard> socket_cpuComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (int) (m1.getSocket_cpu().compareTo(m2.getSocket_cpu()));
		}
	};

	public static Comparator<Motherboard> formFactorComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (int) (m1.getFormFactor().compareTo(m2.getFormFactor()));
		}
	};

	public static Comparator<Motherboard> ramSlotsComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (m2.getRamSlots() > m1.getRamSlots() ? -1 : (m2.getRamSlots() == m1.getRamSlots() ? 0 : 1));
		}
	};

	public static Comparator<Motherboard> maxRamComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			int r1 = Integer.parseInt(m1.getMaxRam().replaceAll(" GB", ""));
			int r2 = Integer.parseInt(m2.getMaxRam().replaceAll(" GB", ""));
			return (r2 > r1 ? -1 : (r2 == r1 ? 0 : 1));
		}
	};

	public static Comparator<Motherboard> colorComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (int) (m1.getColor().compareTo(m2.getColor()));
		}
	};

	public static Comparator<Motherboard> priceComparator = new Comparator<Motherboard>() {
		@Override
		public int compare(Motherboard m1, Motherboard m2) {
			return (m2.getPrice() > m1.getPrice() ? -1 : (m2.getPrice() == m1.getPrice() ? 0 : 1));
		}
	};

	@Override
	public String toString() {
		return String.format("%-40s%-15s%-15s%-5d%-10s%-20s%-10d%-5d", super.getName(), this.socket_cpu,
				this.formFactor, this.ramSlots, this.maxRam, this.color, super.getPrice(), super.getId());
	}

}
