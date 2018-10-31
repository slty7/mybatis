package com.stly7.mybatis_annotation.many2many.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import com.stly7.mybatis_annotation.many2many.pojo.Order;

public interface OrderMapper {
	@Select("select * from order_")
    @Results({
           @Result(property = "id", column = "id"),
           @Result(
        		   property = "orderItems", 
        		   javaType = List.class, 
        		   column = "id", 
                   many = @Many(select = "com.stly7.mybatis_annotation.many2many.mapper.OrderItemMapper.listByOrder"))
           })      
   public List<Order> list();
}
