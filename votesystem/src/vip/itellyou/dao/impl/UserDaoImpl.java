package vip.itellyou.dao.impl;

import java.sql.ResultSet;

import vip.itellyou.dao.UserDao;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;

/**
 * �û����ݷ����ࣺ�̳�BaseDaoImpl���࣬ʵ��UserDao�ӽӿ�
 * @author Ma Wenhai
 *
 */
public class UserDaoImpl extends BaseDaoImpl 
implements UserDao{

	@Override
	public String getInsertSql(Object data) {
		//���������û���sql���
		User user = (User)data;
		return "insert into t_user(name,pwd,online) "+
		    " values('"+user.getName()+"','"+user.getPwd()+"',"+user.getOnline()+")";
	}

	@Override
	public String getFindAllSql() {		
		return "select * from t_user";
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		User user = new User();//����ʵ�������
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPwd(rs.getString("pwd"));
		user.setOnline(rs.getInt("online"));
		
		return user;
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		//������������ѯ�û�
		//����������ת�ͳ��������
		UserQueryModel qm = (UserQueryModel)queryModel;
		//��дsql���
		StringBuilder sb=new StringBuilder();
		sb.append("select * from t_user ");
		sb.append(" where 1=1 ");
		//qm��������ʲô����ֵ������sql�����дʲô����
		if(qm.getName()!=null 
				&& qm.getName().trim().length()>0){
			sb.append(" and name='"+qm.getName()+"' ");
		}
		if(qm.getPwd()!=null
			&& qm.getPwd().trim().length()>0){
			sb.append(" and pwd='"+qm.getPwd()+"' ");
		}
		if(qm.getOnline()>=1){
			sb.append(" and online="+qm.getOnline());
		}
		return sb.toString();
	}

}
