package com.stly7.dynamic_sql_where;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.dynamic_sql_where.pojo.Product;

public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/dynamic_sql_where/mybatis_dynamic_where.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		
		System.out.println("多条件查询");
        Product p = new Product();
        p.setId(6);
        p.setName("product zz");
        p.setPrice(99.99f);
        //session.update("updateProduct",p);
        
        listAll(session);      
        session.commit();
        session.close();
		
		
	}

	private static void listAll(SqlSession session) {
		Map<String,Object> params = new HashMap<>();
        //params.put("name","a");
        //params.put("price","10");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }
	}
}
