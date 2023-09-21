package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoidao {
	public Connection cn;

	public void KetNoi() throws Exception {
		// B1: Xac dinh he qtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh hqtcsdl");
		String url = "jdbc:sqlserver://LAPTOP-MF2QCOS3\\SQLEXPRESS:1433;databaseName=QLGiay;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}
