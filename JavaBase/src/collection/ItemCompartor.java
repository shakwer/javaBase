package collection;

import java.util.Comparator;

public class ItemCompartor implements Comparator<Item> {
	public int compare(Item item1,Item item2) {
		return item1.getDescription().compareTo(item2.getDescription());
	}
}
