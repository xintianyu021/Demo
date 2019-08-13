package com.neu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neu.entity.Dept;

public interface DeptMapper {
	List<Dept> getAll();

	Dept getById(int deptno);
	
	int insert(Dept dept);
	
	int update(Dept dept);
	
	int delete(int deptno);
	//使用注解解决多参数传递问题
	List<Dept> getByName(@Param("dname")String dname,@Param("loc")String loc);
	//使用map解决多参数传递问题
	List<Dept> getByName2(Map<String, String> map);
	//使用${} 替代 #{}
	List<Dept> getAllForSort(String columnName);
	//动态sql：if、trim、where
	List<Dept> find(Dept dept);
	
}















