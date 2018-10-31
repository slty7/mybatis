package com.stly7.mybatis_annotation.many2many.mapper;


import org.apache.ibatis.annotations.Select;

import com.stly7.mybatis_annotation.many2many.pojo.Category;

public interface CategoryMapper {
	
	@Select(" select * from category_ where id = #{id}")
    public Category get(int id);
}
