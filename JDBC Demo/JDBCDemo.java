import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author ������
 * @className JDBCDemo.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function jdbcģ�壬�����������ݿ��������
 */
public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// װ��SQL����
			conn = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/test", "root", "root");// ������������
			Statement stm = conn.createStatement();//����statement����ִ��sql���
			String sql = "INSERT INTO User(id,username,password) VALUES('1','wjm','wjm')";//hql���
			stm.execute(sql);//ִ��sql
			stm.close();//�ر�statemetn����
			conn.close();//�ر����ݿ�����
			System.out.println("����ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
