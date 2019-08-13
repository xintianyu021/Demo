package com.neu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neu.entity.Emp;

public interface EmpMapper {
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> getAll();
	Emp getById(int empno);
	//使用注解解决多参数传递问题
	List<Emp> getByName(@Param("ename")String ename,@Param("job")String job);
	//使用map集合解决多参数传递问题
	List<Emp> getByName2(Map<String, Object> map);
	//使用${} 代替 #{}
	List<Emp> getAllBySort(String columnName);
	//动态sql：if、trim、where
	List<Emp> find(Emp emp);

}
