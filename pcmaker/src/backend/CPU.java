package backend;

import java.util.Comparator;

public class CPU extends Components {
	private int coreCount;
	private String coreClock;
	private String boostClock;
	private String tdp;
	private String integratedGraphics;
	private String smt;

	public CPU(String name, int coreCount, String coreClock, String boostClock, String tdp, String integratedGraphics,
			String smt, int price, int id) {
		super.setName(name);
		this.coreCount = coreCount;
		this.coreClock = coreClock;
		this.boostClock = boostClock;
		this.tdp = tdp;
		this.integratedGraphics = integratedGraphics;
		this.smt = smt;
		super.setPrice(price);
		super.setId(id);
	}

	public int getCoreCount() {
		return coreCount;
	}

	public void setCoreCount(int coreCount) {
		this.coreCount = coreCount;
	}

	public String getCoreClock() {
		return coreClock;
	}

	public void setCoreClock(String coreClock) {
		this.coreClock = coreClock;
	}

	public String getBoostClock() {
		return boostClock;
	}

	public void setBoostClock(String boostClock) {
		this.boostClock = boostClock;
	}

	public String getTdp() {
		return tdp;
	}

	public void setTdp(String tdp) {
		this.tdp = tdp;
	}

	public String getIntegratedGraphics() {
		return integratedGraphics;
	}

	public void setIntegratedGraphics(String integratedGraphics) {
		this.integratedGraphics = integratedGraphics;
	}

	public String getSmt() {
		return smt;
	}

	public void setSmt(String smt) {
		this.smt = smt;
	}

	public static Comparator<CPU> nameComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (c2.getId() > c1.getId() ? -1 : (c2.getId() == c1.getId() ? 0 : 1));
		}
	};

	public static Comparator<CPU> coreCountComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (c2.getCoreCount() > c1.getCoreCount() ? -1 : (c2.getCoreCount() == c1.getCoreCount() ? 0 : 1));
		}
	};

	public static Comparator<CPU> coreClockComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (int) (c1.getCoreClock().compareTo(c2.getCoreClock()));
		}
	};

	public static Comparator<CPU> boostClockComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (int) (c1.getBoostClock().compareTo(c2.getBoostClock()));
		}
	};

	public static Comparator<CPU> tdpComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			int t1 = Integer.parseInt(c1.getTdp().replaceAll(" W", ""));
			int t2 = Integer.parseInt(c2.getTdp().replaceAll(" W", ""));
			return (t2 > t1 ? -1 : (t2 == t1 ? 0 : 1));
		}
	};

	public static Comparator<CPU> integratedGraphicsComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (int) (c1.getIntegratedGraphics().compareTo(c2.getIntegratedGraphics()));
		}
	};

	public static Comparator<CPU> smtComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (int) (c1.getSmt().compareTo(c2.getSmt()));
		}
	};

	public static Comparator<CPU> priceComparator = new Comparator<CPU>() {
		@Override
		public int compare(CPU c1, CPU c2) {
			return (c2.getPrice() > c1.getPrice() ? -1 : (c2.getPrice() == c1.getPrice() ? 0 : 1));
		}
	};
	
	@Override
	public String toString() {
		return String.format("%-25s%-5d%-10s%-10s%-10s%-25s%-5s%-10d%-5d", super.getName(), this.coreCount, this.coreClock,
				this.boostClock, this.tdp, this.integratedGraphics, this.smt, super.getPrice(), super.getId());
	}

}
