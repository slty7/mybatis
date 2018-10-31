package com.stly7.mybatis_annotation.dynamic_sql.mapper;


import org.apache.ibatis.annotations.Select;

import com.stly7.mybatis_annotation.many2many.pojo.Category;

public interface CategoryMapper_old {
	
	@Select(" select * from category_ where id = #{id}")
    public Category get(int id);
}
