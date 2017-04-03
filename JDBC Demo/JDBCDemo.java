import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 王嘉明
 * @className JDBCDemo.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function jdbc模板，用来连接数据库插入数据
 */
public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 装载SQL驱动
			conn = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/test", "root", "root");// 创建数据连接
			Statement stm = conn.createStatement();//创建statement对象执行sql语句
			String sql = "INSERT INTO User(id,username,password) VALUES('1','wjm','wjm')";//hql语句
			stm.execute(sql);//执行sql
			stm.close();//关闭statemetn对象
			conn.close();//关闭数据库连接
			System.out.println("插入成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
