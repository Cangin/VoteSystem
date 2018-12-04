package vip.itellyou.dao.impl;

import java.sql.ResultSet;

import vip.itellyou.dao.UserDao;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;

/**
 * 用户数据访问类：继承BaseDaoImpl父类，实现UserDao子接口
 * @author Ma Wenhai
 *
 */
public class UserDaoImpl extends BaseDaoImpl 
implements UserDao{

	@Override
	public String getInsertSql(Object data) {
		//返回新增用户的sql语句
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
		User user = new User();//创建实体类对象
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPwd(rs.getString("pwd"));
		user.setOnline(rs.getInt("online"));
		
		return user;
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		//按照条件来查询用户
		//将条件向下转型成子类对象
		UserQueryModel qm = (UserQueryModel)queryModel;
		//编写sql语句
		StringBuilder sb=new StringBuilder();
		sb.append("select * from t_user ");
		sb.append(" where 1=1 ");
		//qm对象中有什么条件值，就向sql语句中写什么条件
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
