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

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config_one2many_base.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();

		// 查询
		List<Category> cs = session.selectList("listCategory");
		//List<Product> ps = session.selectList("com.stly7.one2many_base.pojo.listProduct");
		// for (Category category : cs) {
		// System.out.println(category.getId() + " : " + category.getName());
		// }
		// for (Product p : ps) {
		// System.out.println(p.getId() + " : " + p.getName() + " : " +
		// p.getPrice());
		// }

		// 这里没有spring框架只能new一个对象了
		// Category c = new Category();

		// 插入
		// c.setName("王五");
		// session.insert("addCategory", c);
		// session.commit();

		// 删除
		// List<Integer> list = new ArrayList<>();
		// list.add(3);
		// list.add(4);
		// for (Integer i : list) {
		// c.setId(i);
		// session.delete("deleteCategory", c);
		// session.commit();
		// }

		// 修改
		// List<Category> list = new ArrayList<>();
		// c.setId(1);
		// c.setName("水果");
		// list.add(c);
		// 如果是一个同一个对象所有的list 对象的值都会直接引用一个对象的引用的,
		// 所以值都是一样的
		// session.update("updateCategory", c);
		// session.commit();

		List<Category> cs1 = session.selectList("listCategory");
		for (Category c1 : cs1) {
			System.out.println(c1);
		}
	}

}
