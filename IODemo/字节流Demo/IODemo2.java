import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author 王嘉明
 * @className IODemo2.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function IO字节流Demo
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
		File f=new File("D:"+File.separator+"wjm.txt");//新建wjm.txt，利用separator解决路径斜杆兼容问题
		OutputStream out=new FileOutputStream(f);//构造输出函数
		String str="测试一下";
		byte b[]=str.getBytes();//转换字节
		out.write(b);
		//不关闭输出流
	}
}
