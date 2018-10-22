package com.stly7.many2many;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.many2many.pojo.Order;
import com.stly7.many2many.pojo.OrderItem;

public class TestMany2Many {
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/many2many/mybatis-config_many2many.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		listOrder(session);
		session.commit();
		session.close();
	}
	
	private static void listOrder(SqlSession session) {
		List<Order> os = session.selectList("listOrder");
		for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois= o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
	}
}
