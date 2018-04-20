package chapterone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ͨ�����л��ͷ����л�ʵ�ֿ�¡
 * @author user
 *
 */
public class TestReflectClone {
	public TestReflectClone() {
		throw new AssertionError();
	}
	
	public static <T>T clone(T obj)throws Exception{
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bout);
		out.writeObject(obj);
		
		ByteArrayInputStream bin =new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream in=new ObjectInputStream(bin);
		return(T)in.readObject();
	}
}
