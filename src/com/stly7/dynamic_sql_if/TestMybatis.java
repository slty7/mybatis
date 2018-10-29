package com.stly7.dynamic_sql_if;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.dynamic_sql_if.pojo.Product;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
        String resource = "com/stly7/dynamic_sql_if/mybatis_dynamic_if.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        System.out.println("查询所有的");
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p);
        }
         
        System.out.println("模糊查询");
        Map<String,Object> params = new HashMap<>();
        params.put("name","a");
        //List<Product> ps2 = session.selectList("listProductByName",params);
        //改造后
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }      
         
        session.commit();
        session.close();
  
    }
}
