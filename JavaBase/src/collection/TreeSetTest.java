package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Item>parts=new TreeSet<>();
		parts.add(new Item("aa", 1234));
		parts.add(new Item("W", 4567));
		parts.add(new Item("Modem", 9912));
		System.out.println(parts);
		for (Item item : parts) {
			System.out.println(item.getDescription()+","+item.getPartNumber());
		}
		
		
		
		SortedSet<Item>sortByDescription=new TreeSet<>(new Comparator<Item>() {
			
			public int compare(Item a, Item b) {
				String descA=a.getDescription();
				String descB=b.getDescription();
				return descA.compareTo(descB);
			}
		});
		
		sortByDescription.addAll(parts);
//		Arrays.sort(parts, new ItemCompartor());
//		Arrays.sort(parts);
		System.out.println(parts.last());
		System.out.println(parts);
		for (Item item : parts) {
			System.out.println(item.getDescription()+","+item.getPartNumber());
		}
	}
}
