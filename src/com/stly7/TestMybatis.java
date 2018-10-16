package com.stly7;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.pojo.Category;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory 
		= new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = factory.openSession();
		
		List<Category> list = session.selectList("listCategory");
		//session.selectList("com.stly7.pojo.listCategory");
		for (Category category : list) {
			System.out.println(category.getId() + " : " + category.getName());
		}
	}
}
