import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author ������
 * @className IODemo2.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function IO�ֽ���Demo
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
		File f=new File("D:"+File.separator+"wjm.txt");//�½�wjm.txt������separator���·��б�˼�������
		OutputStream out=new FileOutputStream(f);//�����������
		String str="����һ��";
		byte b[]=str.getBytes();//ת���ֽ�
		out.write(b);
		//���ر������
	}
}
