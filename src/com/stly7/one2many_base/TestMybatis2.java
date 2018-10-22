package com.stly7.one2many_base;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.one2many_base.pojo.Category;
import com.stly7.one2many_base.pojo.Product;

public class TestMybatis2 {
	public static void main(String[] args) throws IOException {
		String resource = "com/stly7/one2many_base/mybatis-config_one2many_base.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();
		List<Category> cs = session.selectList("listCategory");
		System.out.println("执行了");
		for (Category c : cs) {
			System.out.println(c);
			List<Product> ps = c.getProducts();
			for (Product p : ps) {
				System.out.println("\t" + p);
			}
		}
	}

}
