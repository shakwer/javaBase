package generic;

public class PairTest3 {
	public static void main(String[] args) {
		
	}
}
class PairAlg{
	public static boolean hasNulls(Pair<?>p) {
		return p.getFirst()==null||p.getSecond()==null;
	}
	
	public static void swap(Pair<?>p) {
		swagHelper(p);
	}
	
	public static<T> void  swagHelper(Pair<T>p) {
		T t=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}