package vip.itellyou.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݷ��ʵĸ����ࣺ��ȡ���Ӷ����ͷ���Դ
 * @author Ma Wenhai
 *
 */
public class DbHelper {
	//��ȡ���Ӷ���
	//1 ����c3p0�����ݿ����ӳض���
	private static DataSource dataSource = 
			new ComboPooledDataSource();
	public static Connection getConnection() 
			throws Exception{
		return  dataSource.getConnection();
	}
	
	//�ͷ���Դ
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






