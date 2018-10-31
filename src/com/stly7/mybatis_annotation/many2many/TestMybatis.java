package com.stly7.mybatis_annotation.many2many;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.mybatis_annotation.dynamic_sql.mapper.OrderMapper;
import com.stly7.mybatis_annotation.dynamic_sql.pojo.Order;
import com.stly7.mybatis_annotation.dynamic_sql.pojo.OrderItem;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
        String resource = "com/stly7/mybatis_annotation/dynamic_sql/mybatis_config_annocation_dynamic_sql.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        
        listOrder(session);
        session.commit();
        session.close();
  
    }
 
    private static void listOrder(SqlSession session) {
        OrderMapper mapper =session.getMapper(OrderMapper.class);
        List<Order> os = mapper.list();
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois= o.getOrderItems();
            if(null!=ois){
                for (OrderItem oi : ois) {
                    System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
                }              
            }
 
        }
    }
}
