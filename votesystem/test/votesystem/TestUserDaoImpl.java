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
		// 创建目标类的对象，调用目标方法，得到实际运行的结果
		UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User();
		user.setName("Rose");
		user.setPwd("123456");
		user.setOnline(1);
		
		int actual = userDao.insert(user);
		
		
		// 写下来 预计的结果
		int expected=1;
		// 使用断言类比较预计的结果和实际运行的结果
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