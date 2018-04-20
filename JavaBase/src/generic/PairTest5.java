package generic;

public class PairTest5 {
	
	/**
	 * ʹ��class<T>������������ƥ��
	 * @param c
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T>Pair<T>makePair(Class<T> c) throws InstantiationException,IllegalAccessException{
		return new Pair<>(c.newInstance(),c.newInstance());
	}
	
	public static void main(String[] args)throws InstantiationException,IllegalAccessException {
		makePair(Employee.class);
	}
}
