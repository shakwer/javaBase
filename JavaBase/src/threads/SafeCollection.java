package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import com.sun.javafx.collections.MappingChange.Map;

public class SafeCollection  {
	public static void main(String[] args) {
		//ͬ����װ��
		//�κμ����඼����ʹ��ͬ����װ������̰߳�ȫ
		
		List<String>synchArrayList=Collections.synchronizedList(new ArrayList<String>());
//		Map<String, String>synchHashMap=Collections.synchronizedMap(new HashMap<String, String>());
		
	}
}
