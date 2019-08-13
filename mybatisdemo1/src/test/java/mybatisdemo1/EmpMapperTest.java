package mybatisdemo1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neu.entity.Dept;
import com.neu.entity.Emp;
import com.neu.mapper.EmpMapper;

public class EmpMapperTest {
	private SqlSession session;
	private EmpMapper empMapper;
	
	
	@Before
	public void setup() throws IOException {
		//得到配置文件的输入流
		InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
		//得到SqlSession对象，相当于数据库的连接
		session = sqlSessionFactory.openSession();
		//得到接口的实现类对象
		empMapper = session.getMapper(EmpMapper.class);
	}
	@After
	public void after() {
		session.close();
	}
	@Test
	public void testGetAll() {
		List<Emp> list = empMapper.getAll();
		System.out.println(list);
	}
	
	@Test
	public void testGetById() {
		Emp emp = empMapper.getById(7369);
		System.out.println(emp);
	}
	
	@Test
	public void testInsert() {
		Dept dept = new Dept(66, "BMW", "沈阳");
		Date date = new Date();
		Emp emp = new Emp(7777, "Ronaldo", "ST", 0, date, 10000.0, 2000.0, dept);
		int n = empMapper.insert(emp);
		System.out.println(n);
		session.commit();
	}
	
	@Test
	public void testUpdate() {
		Dept dept = new Dept(66, "BMW", "沈阳");
		Date date = new Date();
		Emp emp = new Emp(7777, "Ronaldo", "ST", 123, date, 10000.0, 2000.0, dept);
		int n = empMapper.update(emp);
		System.out.println(n);
		session.commit();
	}
	
	@Test
	public void testDelete() {
		
		int n = empMapper.delete(7777);
		System.out.println(n);
		session.commit();
	}
	
	@Test
	public void testGetByName() {
		List<Emp> list = empMapper.getByName("KING", "PRESIDENT");
		System.out.println(list);
	}
	
	@Test
	public void testGetByName2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ename", "KING");
		map.put("job", "PRESIDENT");
		List<Emp> list = empMapper.getByName2(map);
		System.out.println(list);
	}
	
	
}
