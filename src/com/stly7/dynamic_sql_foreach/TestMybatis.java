package com.stly7.dynamic_sql_foreach;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.dynamic_sql_foreach.pojo.Product;

public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/dynamic_sql_foreach/mybatis_dynamic_foreach.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
        List<Product> ps2 = session.selectList("listProduct",ids);
        for (Product p : ps2) {
            System.out.println(p);
        }  
        session.commit();
        session.close();
		
		
	}

	private static void listAll(SqlSession session) {
		
	}
}
