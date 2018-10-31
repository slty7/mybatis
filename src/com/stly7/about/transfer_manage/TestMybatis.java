package com.stly7.about.transfer_manage;
  
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.stly7.about.transfer_manage.mapper.CategoryMapper;
import com.stly7.about.transfer_manage.pojo.Category;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException, SQLException {
        String resource = "com/stly7/about/transfer_manage/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        
        Category c1 = new Category();
        c1.setName("长度够短的名称");
        mapper.add(c1);
         
        Category c2 = new Category();
        c2.setName("超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称");
        mapper.add(c2);       
 
        listAll(mapper);
        session.commit();
        session.close();
   
    }
  
    private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}