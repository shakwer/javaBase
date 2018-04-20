package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import com.sun.javafx.collections.MappingChange.Map;

public class SafeCollection  {
	public static void main(String[] args) {
		//同步包装器
		//任何集合类都可以使用同步包装器变的线程安全
		
		List<String>synchArrayList=Collections.synchronizedList(new ArrayList<String>());
//		Map<String, String>synchHashMap=Collections.synchronizedMap(new HashMap<String, String>());
		
	}
}
