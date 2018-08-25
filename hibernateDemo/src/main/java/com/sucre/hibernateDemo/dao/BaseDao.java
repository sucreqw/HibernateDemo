package com.sucre.hibernateDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

/**
 * 这是一个通用的 增删改查 dao类
 * 
 * @author sucre
 *
 */
public class BaseDao {
	
	// 创建一个sessionFactory工厂类 通过它建立一个数据库连接会话
	SessionFactory sessionFactory = null;
	// sessionFactory 又需要另一个类,配置类
	Configuration configuration = null;
	// 注册到注册类,使配置文件生效
	ServiceRegistry serviceRegistry = null;
	// 操作数据库的session对象
	Session session = null;
	// 事务处理器
	Transaction transaction = null;
/**
	 * 初始化hibernate配置
	 */
	public void init() {
		if(session==null || !session.isConnected()) {
			// sessionFactory 又需要另一个类,配置类,封装有我们配置文件的配置信息
			configuration = new Configuration().configure();// 返回的configuration 包含了hibernate.cfg.xml 文件里的具体信息
			// 注册到注册类,使配置文件生效
			serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();
			// 拿到工厂类,终于.....
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			// 通过工厂类开启session对象
			session = sessionFactory.openSession();
			// 开启事务
			transaction = session.beginTransaction();
		}
	}
    
	/**
	 * 结束操作后关闭资源
	 */
	public void close() {
		//提交事务
		if(transaction!=null) {transaction.commit();}
		//关闭session
		if(session!=null) {session.close();}
		//关闭工厂类
		if(sessionFactory!=null) {sessionFactory.close();}
	}
	
	/**
	 * 数据库增加操作
	 * @param <T>
	 */
	public void addEntity(Object entity) {
		if(session!=null && session.isConnected()) {session.save(entity);}
	}
	
	/**
	 * 数据库删除操作
	 */
	public void deleteEntity(Object entity) {
		if(session!=null && session.isConnected()) {session.delete(entity);}
	}
	
	/**
	 * 数据库的更新操作
	 * @param entity
	 */
	public void updateEntity(Object entity) {
		if(session!=null && session.isConnected()) {session.update(entity);}
	}
	
	/**
	 * 数据库查询操作
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T getEntity(Class<T> clazz,int id){
		if(session!=null && session.isConnected()) {return session.get(clazz, id);}
		return null;
	}
	
	/**
	 * 根据字段模糊查询数据库操作
	 * @param clazz 表对应的对象的class
	 * @param field 要查询的字段
	 * @param queryString 要查询的字符
	 * @return 一个对象的集合
	 */
	public <T> List<T> searchEntity(Class<T> clazz,String field,String queryString){
		
		 // SQL代码 .如果直接编写sql语句,like后面要跟单引号
        String hql = "from "+ clazz.getSimpleName()+" as u where u."+ field +" like :name";
		Query<?> query = session.createQuery(hql);
		//用点位符 后面不用单引号
		query.setParameter("name", "%" + queryString + "%");
		
		List<T> result = (List<T>) query.list();
        return result; 
	}
	
}
