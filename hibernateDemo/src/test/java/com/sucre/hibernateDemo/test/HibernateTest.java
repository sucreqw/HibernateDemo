package com.sucre.hibernateDemo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.sucre.hibernateDemo.dao.BaseDao;
import com.sucre.hibernateDemo.entity.User;

public class HibernateTest {

	@Test
	public void test() {
		//创建一个sessionFactory工厂类 通过它建立一个数据库连接会话
		SessionFactory sessionFactory=null;
		//sessionFactory 又需要另一个类,配置类,封装有我们配置文件的配置信息
		Configuration configuration=new Configuration().configure();//返回的configuration 包含了hibernate.cfg.xml 文件里的具体信息
		//注册到注册类,使配置文件生效
		ServiceRegistry serviceRegistry=configuration.getStandardServiceRegistryBuilder().build();
		//拿到工厂类,终于.....
		sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		//通过工厂类开启session对象
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction transaction =session.beginTransaction();
		//操作数据库
		User u=new User();
		/*u.setToken("test");
		u.setRegday(new Date());
		u.setIsblock(false);
		u.setIsmanager(false);
		u.setNickname("test");*/
		
		//u=session.get(u.getClass(), 3);
		//session.save(u);
		//session.delete(u);
		//u.setRefresh_token("1212");
		//session.update(u);
		//System.out.println(u);
	    transaction.commit();
		session.close();
		sessionFactory.close();
	}
    
	@Test
	public void daoTest() {
		User u=new User();
		BaseDao b=BaseDao.getInstance();
		b.init();
		//u=b.getEntity(u.getClass(), 1);
		List<User> list= (List<User>) b.searchEntity(u.getClass(),"refresh_token","test");
		b.close();
	   // System.out.println(list.get(0));
	}
}
