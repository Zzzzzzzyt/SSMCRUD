package com.zyt.test;

import com.zyt.ssmcrud.bean.Department;
import com.zyt.ssmcrud.bean.Employee;
import com.zyt.ssmcrud.dao.DepartmentMapper;
import com.zyt.ssmcrud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试Department
     */
    @Test
    public void testCRUD(){

        System.out.println(departmentMapper);
        //departmentMapper.insertSelective(new Department(null,"开发部"));
        //departmentMapper.insertSelective(new Department(null,"测试部"));

        //employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@163.com",1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0;i < 1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+""+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@163.com",1));
        }
        System.out.println("批量完成");
    }

}
