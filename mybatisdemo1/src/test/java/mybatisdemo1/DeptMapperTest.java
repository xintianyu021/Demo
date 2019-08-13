package mybatisdemo1;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neu.entity.Dept;
import com.neu.mapper.DeptMapper;

public class DeptMapperTest {
	private SqlSession session;
	private DeptMapper deptMapper;
	
	
	@Before
	public void setup() throws IOException {
		//得到配置文件的输入流
		InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
		//得到SqlSession对象，相当于数据库的连接
		session = sqlSessionFactory.openSession();
		//得到接口的实现类对象
		deptMapper = session.getMapper(DeptMapper.class);
	}
	@After
	public void after() {
		session.close();
	}

	@Test
	public void testGetAll() throws Exception {	
		List<Dept> list = deptMapper.getAll();
		System.out.println(list);	
	}
	
	@Test
	public void find() throws Exception {	
		Dept dept = new Dept(null,null,null);
		List<Dept> list = deptMapper.find(dept);
		System.out.println(list);	
	}
	
	
	@Test
	public void testGetById() throws Exception {	
		Dept dept = deptMapper.getById(10);
		System.out.println(dept);	
	}
	@Test
	public void testInsert() throws Exception {
		int n = deptMapper.insert(new Dept(77, "qwer", "qwer"));
		//提交事务
		session.commit();
		System.out.println(n);		
	}
	@Test
	public void testUpdate() throws Exception {
		int n = deptMapper.update(new Dept(50, "1", "qwer"));
		//提交事务
		session.commit();
		System.out.println(n);
	}
	@Test
	public void testDelete() throws Exception {
		int n = deptMapper.delete(50);
		//提交事务
		session.commit();
		System.out.println(n);	
	}
	
	@Test
	public void testGetByName() throws Exception {	
		List<Dept> list = deptMapper.getByName("SALES", "CHICAGO");
		System.out.println(list);	
	}
	
	@Test
	public void testGetByName2() throws Exception {	
		Map<String, String> map = new HashMap<String, String>();
		map.put("dname", "SALES");
		map.put("loc", "CHICAGO");
		List<Dept> list = deptMapper.getByName2(map);
		System.out.println(list);	
	}
	
	@Test
	public void testGetAllForSort() throws Exception {	
		List<Dept> list = deptMapper.getAllForSort("loc");
		System.out.println(list);	
	}
	
	@Test
	public void test() {
		Dept dept = new Dept(10,null,"沈阳");
		StringBuilder stb = new StringBuilder("select * from dept where 1=1 ");
		if(dept.getDeptno()!=null) {
			stb.append(" and deptno = "+dept.getDeptno());
		}
		if(dept.getDname()!=null) {
			stb.append(" and dname = "+dept.getDname());
		}
		if(dept.getLoc()!=null) {
			stb.append(" and loc = "+dept.getLoc());
		}
		System.out.println(stb.toString());
	}
}






















