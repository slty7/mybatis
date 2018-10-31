package com.stly7.mybatis_annotation.curd;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.mybatis_annotation.curd.mapper.CategoryMapper;
import com.stly7.mybatis_annotation.curd.pojo.Category;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String resource = "com/stly7/mybatis_annotation/curd/mybatis_config_annotation_crud.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    SqlSession session = sqlSessionFactory.openSession();
	    CategoryMapper mapper = session.getMapper(CategoryMapper.class);

		   /* add(mapper);
		    delete(mapper);
		    get(mapper);
		    update(mapper);*/
		    listAll(mapper);
		          
		    session.commit();
		    session.close();
	}
	
	private static void update(CategoryMapper mapper) {
	    Category c= mapper.get(8);
	    c.setName("修改了的Category名稱");
	    mapper.update(c);
	    listAll(mapper);
	}
	
	private static void get(CategoryMapper mapper) {
	    Category c= mapper.get(8);
	    System.out.println(c.getName());
	}
	
	private static void delete(CategoryMapper mapper) {
	    mapper.delete(2);
	    listAll(mapper);
	}
	
	private static void add(CategoryMapper mapper) {
	    Category c = new Category();
	    c.setName("新增加的Category");
	    mapper.add(c);
	    listAll(mapper);
	}
	
	private static void listAll(CategoryMapper mapper) {
	    List<Category> cs = mapper.list();
	    for (Category c : cs) {
	        System.out.println(c.getName());
	    }
	}
}
