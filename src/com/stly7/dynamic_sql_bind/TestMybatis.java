package com.stly7.dynamic_sql_bind;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.dynamic_sql_bind.pojo.Product;

public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/dynamic_sql_bind/mybatis_dynamic_bind.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		 Map<String, String> params =new HashMap();
	     params.put("name", "product");
	         
	      List<Product> ps = session.selectList("listProduct",params);
	      for (Product p : ps) {
	          System.out.println(p);
	      }
        session.commit();
        session.close();
		
		
	}

	private static void listAll(SqlSession session) {
		
	}
}
