package backend;

import java.util.Comparator;

public class VideoCard extends Components {
	private String chipset;
	private String memory;
	private String coreClock;
	private String boostClock;
	private String _interface;
	private String color;
	private String TDP;

	public VideoCard(String name, String chipset, String memory, String coreClock, String boostClock, String _interface,
			String color, int price, int id, String tdp) {
		super.setName(name);
		this.chipset = chipset;
		this.memory = memory;
		this.coreClock = coreClock;
		this.boostClock = boostClock;
		this._interface = _interface;
		this.color = color;
		this.TDP = tdp;
		super.setPrice(price);
		super.setId(id);
	}

	public String getChipset() {
		return chipset;
	}

	
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
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

	public String get_Interface() {
		return _interface;
	}

	public void set_Interface(String _interface) {
		this._interface = _interface;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTdp() {
		return TDP;
	}

	
	public void setTdp(String tdp) {
		this.TDP = tdp;
	} 
	
	public static Comparator<VideoCard> nameComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (v2.getId() > v1.getId() ? -1 : (v2.getId() == v1.getId() ? 0 : 1));
		}
	};

	public static Comparator<VideoCard> chipsetComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {

			try {
				String[] tokens1 = v1.getChipset().split(" ");
				String[] tokens2 = v2.getChipset().split(" ");
				int i = 0;
				while (tokens1[i].equals(tokens2[i])) {
					i++;
				}
				int t1 = Integer.parseInt(tokens1[i]);
				int t2 = Integer.parseInt(tokens2[i]);
				return (t2 > t1 ? -1 : (t2 == t1 ? 0 : 1));
			} catch (Exception e) {
				return (int) (v1.getChipset().compareTo(v2.getChipset()));
			}
		}
	};

	public static Comparator<VideoCard> memoryComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			int m1 = Integer.parseInt(v1.getMemory().replaceAll(" GB", ""));
			int m2 = Integer.parseInt(v2.getMemory().replaceAll(" GB", ""));
			return (m2 > m1 ? -1 : (m2 == m1 ? 0 : 1));
		}
	};

	public static Comparator<VideoCard> coreClockComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (int) (v1.getCoreClock().compareTo(v2.getCoreClock()));
		}
	};

	public static Comparator<VideoCard> boostClockComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (int) (v1.getBoostClock().compareTo(v2.getBoostClock()));
		}
	};

	public static Comparator<VideoCard> _interfaceComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (int) (v1.get_Interface().compareTo(v2.get_Interface()));
		}
	};

	public static Comparator<VideoCard> colorComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (int) (v1.getColor().compareTo(v2.getColor()));
		}
	};

	public static Comparator<VideoCard> priceComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			return (v2.getPrice() > v1.getPrice() ? -1 : (v2.getPrice() == v1.getPrice() ? 0 : 1));
		}
	};
	
	public static Comparator<VideoCard> tdpComparator = new Comparator<VideoCard>() {
		@Override
		public int compare(VideoCard v1, VideoCard v2) {
			double t1 = Double.parseDouble(v1.getTdp().replaceAll("W", ""));
			double t2 = Double.parseDouble(v2.getTdp().replaceAll("W", ""));
			return (t2 > t1 ? -1 : (t2 == t1 ? 0 : 1));
		}
	};

	@Override
	public String toString() {
		return String.format("%-30s%-25s%-10s%-10s%-10s%-10s%-15s%-10d%-5d", super.getName(), this.chipset, this.memory,
				this.coreClock, this.boostClock, this._interface, this.color, super.getPrice(), super.getId());
	}
	//havent add tdp
}
