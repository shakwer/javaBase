package collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 元素可以任意插入，却总是按排序的顺序检索，无论何时调用remove方法，总会获得最小元素、
       优先级队列采用一个自我调整的二叉树堆，对树进行插入删除，可以让最小的元素移动到根
 * @author user
 *
 */
public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar>pq=new PriorityQueue<>();
		pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1911,Calendar.FEBRUARY,20));
		pq.add(new GregorianCalendar(1980,Calendar.JANUARY,4));
		pq.add(new GregorianCalendar(1990,Calendar.OCTOBER,10));
		pq.add(new GregorianCalendar(2000,Calendar.AUGUST,15));
		
		System.out.println("Iterating over elements "+pq.size());
		for(GregorianCalendar calendar :pq) {
			System.out.println(calendar.get(Calendar.YEAR));
			
		}
		
		System.out.println("Removing elemets");
		while(!pq.isEmpty()) {
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
		System.out.println(pq.size());
	}
}
