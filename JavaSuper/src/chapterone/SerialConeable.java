package chapterone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ͨ�����л��ͷ����л�ʵ�ֿ�¡
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
			
			
			//����ֱ��clone����ʵ�ֿ�¡
//			return super.clone();
			
			
			return ret;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
