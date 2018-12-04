package votesystem;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;

public class TestUserDaoImpl {
	@Test
	public void testInsert() throws Exception{
		// ����Ŀ����Ķ��󣬵���Ŀ�귽�����õ�ʵ�����еĽ��
		UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User();
		user.setName("Rose");
		user.setPwd("123456");
		user.setOnline(1);
		
		int actual = userDao.insert(user);
		
		
		// д���� Ԥ�ƵĽ��
		int expected=1;
		// ʹ�ö�����Ƚ�Ԥ�ƵĽ����ʵ�����еĽ��
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFindAll() throws Exception{
		UserDaoImpl userDao = new UserDaoImpl();
		List actual = userDao.findAll();
		int expected=6;
		Assert.assertEquals(expected, actual.size());
		
	}
	
	@Test
	public void testFindByCondition() throws Exception{
		UserDaoImpl userDao = new UserDaoImpl();
		UserQueryModel qm = new UserQueryModel();
		qm.setOnline(1);
		qm.setName("Rose");
		List actual = userDao.findByCondition(qm);
		int expected=1;
		Assert.assertEquals(expected, actual.size());
		
	}
	
	
	
	
	
	
	
}