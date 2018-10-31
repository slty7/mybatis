package com.stly7.mybatis_annotation.dynamic_sql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stly7.mybatis_annotation.dynamic_sql.pojo.Product;

public interface ProductMapper {
	
	
	@Select("select * from product_")
	@Results({
		@Result(property="category",
				column="cid",
				one= @One(
						select = "com.stly7.mybatis_annotation.dynamic_sql.mapper.CategoryMapper.get"
						)
				)
		
	})
	public List<Product> list();
	
	
	@Select("select * from product_ where id = #{id}")
    public Product get(int id);
}
