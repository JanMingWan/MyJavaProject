import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author ������
 * @className IODemo.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function io����дtxt�ĵ�
 */
public class IODemo {
	public static void main(String[] args) {
		try {
			// �����ļ�д���ַ���
			FileWriter fileWriter = new FileWriter("wjm.txt");
			// �ַ�������
			BufferedWriter bufWriter = new BufferedWriter(fileWriter);
			bufWriter.write("���������ǵ�һ�в�������");
			bufWriter.newLine();// ����
			bufWriter.write("���ǵڶ��в�������");
			bufWriter.flush();// �ѻ����������
			fileWriter.close();
			bufWriter.close();
			System.out.println("�ɹ�д������");
			System.out.println("-------------------------");
			System.out.println("��ʼ���ļ�");
			FileReader fileReader = new FileReader("wjm.txt");// �����ļ���ȡ�ַ���
			BufferedReader bufReader = new BufferedReader(fileReader);// ����д���ַ�������
			String strLine = null;
			do {
				strLine = bufReader.readLine();
				System.out.println(strLine == null ? "" : strLine);// 3Ŀ�����
			} while (strLine != null);//do-whileѭ�����
			fileReader.close();
			bufReader.close();
			System.out.println("�ļ���ȡ����!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
