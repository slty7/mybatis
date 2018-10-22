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
import com.stly7.many2many.pojo.Product;

public class TestMany2Many2 {
	public static void main(String[] args) throws IOException {
		String path = "com/stly7/many2many/mybatis-config_many2many.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		//addOrderItem(session);
		//deleteOrderItem(session);
		//deleteOrder(session);
		
		listOrder(session);
		session.commit();
		session.close();
	}
	
	
	private static void deleteOrder(SqlSession session) {
		int id = 1;
		session.delete("deleteOrder",id);
	}
	private static void deleteOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        session.delete("deleteOrderItem", oi);     
    }
	
	/**
	 * 建立了让订单000A和产品z建立了关系
			首先通过id分别获取Ordre对象和Product对象，然后创建一个新的OrderItem对象，
			接着设置Order，设置Product，设置数量，最后调用"addOrderItem" 对应的sql语句插入数据。
	 */
	private static void addOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder", 1);
        Product p6 = session.selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);
 
        session.insert("addOrderItem", oi);
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
