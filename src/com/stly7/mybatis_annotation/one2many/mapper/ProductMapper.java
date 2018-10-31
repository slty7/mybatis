package com.stly7.mybatis_annotation.one2many.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.stly7.mybatis_annotation.one2many.pojo.Product;



public interface ProductMapper {
	@Select("select * from product_ where cid = #{cid}")
	public List<Product> listByCategory(int cid);
}
