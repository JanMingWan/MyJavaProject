import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author 王嘉明
 * @className IODemo.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function io流读写txt文档
 */
public class IODemo {
	public static void main(String[] args) {
		try {
			// 创建文件写入字符流
			FileWriter fileWriter = new FileWriter("wjm.txt");
			// 字符缓存流
			BufferedWriter bufWriter = new BufferedWriter(fileWriter);
			bufWriter.write("哈哈，这是第一行测试内容");
			bufWriter.newLine();// 换行
			bufWriter.write("这是第二行测试内容");
			bufWriter.flush();// 把缓冲内容输出
			fileWriter.close();
			bufWriter.close();
			System.out.println("成功写入内容");
			System.out.println("-------------------------");
			System.out.println("开始读文件");
			FileReader fileReader = new FileReader("wjm.txt");// 构建文件读取字符流
			BufferedReader bufReader = new BufferedReader(fileReader);// 构建写入字符流缓存
			String strLine = null;
			do {
				strLine = bufReader.readLine();
				System.out.println(strLine == null ? "" : strLine);// 3目运算符
			} while (strLine != null);//do-while循环语句
			fileReader.close();
			bufReader.close();
			System.out.println("文件读取结束!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
