package chapterone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 通过序列化和反序列化实现克隆
 * @author user
 *
 */
public class SerialConeable implements Cloneable,Serializable{
	public Object clone() {
		try {
			
			ByteArrayOutputStream bout=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bout);
			out.writeObject(this);
			out.close();
			
			ByteArrayInputStream bin=new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in=new ObjectInputStream(bin);
			Object ret=in.readObject();
			in.close();
			
			
			//或者直接clone方法实现克隆
//			return super.clone();
			
			
			return ret;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
