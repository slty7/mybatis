package com.stly7.mybatis_annotation.one2many;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.mybatis_annotation.one2many.mapper.CategoryMapper;
import com.stly7.mybatis_annotation.one2many.pojo.Category;
import com.stly7.mybatis_annotation.one2many.pojo.Product;

public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String source = "com/stly7/mybatis_annotation/one2many/mybatis_config_annocation_one2many.xml";
		InputStream inputStream = Resources.getResourceAsStream(source);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		
		CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
		 
        listAll(mapper);
              
        sqlSession.commit();
        sqlSession.close();
		
	}
	
	private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p.getName());
            }
        }
    }
}
