package com.stly7.many2one;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.many2one.pojo.Category;
import com.stly7.many2one.pojo.Product;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/many2one/mybatis-config_many2one.xml";
		InputStream ips = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session = factory.openSession();
		show(session, "listProduct");
		
		/**
		 * 眼下的多对一关系是
			product(id=5) 对应 category(id=2)
			结合CRUD ，通过Mybatis，做到 product(id=5) 对应category(id=1)
			
			意思是直接修改通过id修改cid
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cid", "2");
			map.put("id", "5");
			session.update("updateProduct", map);
 
			<update id="updateProduct" parameterType="java.util.Map">
			          update product_ set cid=#{cid} where id=#{id}
			</update>
		 */
		Product p = new Product();
		Category c = new Category();
		c.setId(1);
		p.setId(5);
		p.setCategory(c);
		session.update("updateProduct", p);
		session.commit();
		System.out.println("===============");
		show(session, "listProduct");
	}
	
	public static <T> void show(SqlSession session, String type) {
		List<T> list = session.selectList(type);
		for (T t : list) {
			System.out.println(t);
		}
	}
}
