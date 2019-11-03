package backend;

import java.util.ArrayList;
import java.util.Collections;

public class VideoCardSorter {
	private ArrayList<VideoCard> videoCard = new ArrayList<>();

	public VideoCardSorter(ArrayList<VideoCard> videoCard) {
		this.videoCard = videoCard;
	}

	public ArrayList<VideoCard> getSortedByName(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.nameComparator);
		else
			Collections.sort(videoCard, VideoCard.nameComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByChipset(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.chipsetComparator);
		else
			Collections.sort(videoCard, VideoCard.chipsetComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByMemory(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.memoryComparator);
		else
			Collections.sort(videoCard, VideoCard.memoryComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByCoreClock(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.coreClockComparator);
		else
			Collections.sort(videoCard, VideoCard.coreClockComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByBoostClock(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.boostClockComparator);
		else
			Collections.sort(videoCard, VideoCard.boostClockComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedBy_Interface(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard._interfaceComparator);
		else
			Collections.sort(videoCard, VideoCard._interfaceComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByColor(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.colorComparator);
		else
			Collections.sort(videoCard, VideoCard.colorComparator.reversed());
		return videoCard;
	}
	
	public ArrayList<VideoCard> getSortedByTdp(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.tdpComparator);
		else
			Collections.sort(videoCard, VideoCard.tdpComparator.reversed());
		return videoCard;
	}

	public ArrayList<VideoCard> getSortedByPrice(boolean ascending) {
		if (ascending)
			Collections.sort(videoCard, VideoCard.priceComparator);
		else
			Collections.sort(videoCard, VideoCard.priceComparator.reversed());
		return videoCard;
	}

}
