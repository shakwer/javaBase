package collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Ԫ�ؿ���������룬ȴ���ǰ������˳����������ۺ�ʱ����remove�������ܻ�����СԪ�ء�
       ���ȼ����в���һ�����ҵ����Ķ������ѣ��������в���ɾ������������С��Ԫ���ƶ�����
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
