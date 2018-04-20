package collection;

import java.util.Comparator;
import java.util.Objects;

public class Item implements Comparable<Item> {
	private String description;
	private int partNumber;
	
	public Item(String description,int partNumber) {
		this.description=description;
		this.partNumber=partNumber;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	
	public int hashCode() {
		return Objects.hash(description,partNumber);
	}
	@Override
	public int compareTo(Item other) {
		return Integer.compare(partNumber, other.partNumber);
	}
	
	public boolean equals(Object other) {
		if(this==other)return true;
		if(other==null)return false;
		if(getClass()!=other.getClass())return false;
		Item another=(Item)other;
		return Objects.equals(description, another.description)&&partNumber==another.partNumber;
	}
	

	
}
