package collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;
import java.util.Vector;

public class QueueTest {
	public static void main(String[] args) {
//	  Collection
		
		Collection<String> list=new ArrayList<>();
		list.add("1111");
		list.add("aaaa");
		list.add("12321321");
		
		
//		Iterator<String>iterator=list.iterator();//ÇëÇóµü´úÆ÷
//		while(iterator.hasNext()) {
//			String element=iterator.next();
//			iterator.remove();
//			System.out.println(element);
//		}
		
		for (String element : list) {
		System.out.println(element);	
		}
		
		System.out.println(list.size());
		
//		Hashtable<K, V>sHashtable;
		HashMap map;
		Vector vector;
		HashSet set;
		TreeSet tree;
		Deque deque;
		ArrayDeque arrayDeque;

		
	}
}
