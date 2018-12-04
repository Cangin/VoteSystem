package vip.itellyou.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据访问的辅助类：获取连接对象；释放资源
 * @author Ma Wenhai
 *
 */
public class DbHelper {
	//获取连接对象
	//1 定义c3p0的数据库连接池对象
	private static DataSource dataSource = 
			new ComboPooledDataSource();
	public static Connection getConnection() 
			throws Exception{
		return  dataSource.getConnection();
	}
	
	//释放资源
	public static void closeAll(Connection con,
			PreparedStatement pst,ResultSet rs) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(con!=null){
			con.close();
		}
	}
}






