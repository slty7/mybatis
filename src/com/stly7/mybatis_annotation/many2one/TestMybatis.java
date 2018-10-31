package com.stly7.mybatis_annotation.many2one;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stly7.mybatis_annotation.many2one.mapper.ProductMapper;
import com.stly7.mybatis_annotation.many2one.pojo.Product;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
        String resource = "com/stly7/mybatis_annotation/many2one/mybatis_config_annocation_many2one.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
 
        List<Product> ps= mapper.list();
        for (Product p : ps) {
            System.out.println(p + "\t对应的分类是:\t" + p.getCategory().getName());
        }
 
        session.commit();
        session.close();
   
    }
}
