/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Boss;
import com.example.demo.casbean.Address;
import com.example.demo.casbean.Dept;
import com.example.demo.casbean.Employee;
import com.example.demo.casbean.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa{
    @Autowired
    BossDao bossDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DeptDao deptDao;
    @Autowired
    RoleDao roleDao;


    /**
     * 测试默认方法 （JPA）
     */
    @Test
    public void test1(){
        //全部删除
//		bossDao.deleteAllInBatch(); //直接执行一条SQL，全部删除
//		bossDao.deleteAll();//先执行findAll,然后遍历删除
        //批量删除
//        List<Boss> b = new ArrayList<>();
//        b.add(Boss.builder().id(5).build());
//        b.add(Boss.builder().id(6).build());
//		bossDao.delete(b);//遍历删除
//        bossDao.deleteInBatch(b);//直接执行一条SQL，全部删除
        //批量插入
//        List<Boss> b = new ArrayList<>();
//        b.add(Boss.builder().id(5).name("王健林").brand("万达").assets(new BigDecimal(854.34)).build());
//        b.add(Boss.builder().id(6).name("雷军").brand("小米").assets(new BigDecimal(1434.34)).build());
//        bossDao.save(b); //一条条插入
        // Example 按例查询（QBE）是一种用户界面友好的查询技术。 它允许动态创建查询，并且不需要编写包含字段名称的查询
        //Probe: 含有对应字段的实例对象  ExampleMatcher携带有关如何匹配特定字段的详细信息，相当于匹配条件。Example：由Probe和ExampleMatcher组成，用于查询。
        Boss boss = new Boss();
        boss.setName("马");
//        Example<Boss> example = Example.of(boss);//ExampleMatcher 不传，默认全字符匹配-->相当于=
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即 name%
                .withMatcher("name", match -> match.contains())//模糊查询，即 %name%, lamb写法
                .withIgnorePaths("id");//忽略字段，即不管id是什么值都不加入查询条件
        Example<Boss> example = Example.of(boss, matcher);
        System.out.println(bossDao.findAll(example  ).toString());
    }

    /**
     *  测试自定义方法
     */
    @Test
    public void test2(){
//        System.out.println(bossDao.findByBrand("小米"));;
//        System.out.println(bossDao.getByNameOrBrand("王健林", "京东"));
//        System.out.println(bossDao.countByAssets(new BigDecimal(342)));
//        System.out.println(bossDao.findByNameLike("%马%"));
//        System.out.println(bossDao.queryByIdGreaterThanEqualOrderByAssetsDesc(1));

//        System.out.println(bossDao.findByNameLike("%马%", new PageRequest(0,2, Sort.Direction.ASC, "id")).getContent());

//        System.out.println(bossDao.findFirstByOrderByAssetsDesc());
//        System.out.println(bossDao.findTopByOrderByAssetsAsc());
//        System.out.println(bossDao.queryFirst3ByIdGreaterThanEqual(1, new PageRequest(0,5)).getContent());
//        System.out.println(bossDao.findFirst2ByIdGreaterThanEqual(1, new Sort(Sort.Direction.ASC, "assets")));
//        System.out.println(bossDao.queryTop3ByIdGreaterThanEqual(1, new PageRequest(0,5)));

        //自定义部分
        System.out.println(bossDao.updateById("陈发发", "大润花", new BigDecimal(2023), 11));
//        bossDao.deleteById(12);
//        System.out.println(bossDao.findAllBoss());

//        System.out.println(bossDao.findBossAndCar(0));

//        List<Object[]> bossAndCar = bossDao.findBossAndCarSql();
//        List<BossCarVo> bossCarVos = EntityUtils.castEntity(bossAndCar, BossCarVo.class, new BossCarVo());
//        System.out.println(bossCarVos);

    }

    //级联
    @Test
    public void test3(){
        //添加部门
//        List<Employee> employees = new ArrayList<>();
//        employees.add(Employee.builder().name("君君").sex("男")
//                .address(Address.builder().address("辽宁").build())
//                .birthday(new Timestamp(System.currentTimeMillis())).build());
//        employees.add(Employee.builder().name("幂幂").sex("女")
//                .address(Address.builder().address("北京").build())
//                .birthday(new Timestamp(System.currentTimeMillis())).build());
//        Dept dept = Dept.builder().name("财务部").employees(employees).build();
//        deptDao.save(dept);

        //删除部门
//        deptDao.delete(5L);
        //更新角色地址
//        Employee one = employeeDao.findOne(4L);
//        one.setAddress(Address.builder().id(4L).address("大理").build());
//        employeeDao.save(one);

//        Dept one = deptDao.findOne(4L);
        //getOne是懒加载 需要增加这个配置： spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true，否则 抛异常
//        could not initialize proxy - no Session，但这种方式不太友好，建议不要使用
        //每次初始化一个实体的关联就会创建一个临时的session来加载，每个临时的session都会获取一个临时的数据库连接，开启一个新的事物。这就导致对底层连接池压力很大
//        Dept one = deptDao.getOne(4L);
//        System.out.println(one);
        //删除角色
        employeeDao.delete(1L); //若删除员工中，部门为EAGER 立即加载，则无法删除,若要删除，必须联通关联对象也设置为删除状态,或者设置懒加载


        //添加角色
//        Role role1 = Role.builder().name("法师").build();
//        roleDao.save(role1);

        //添加员工
//        Address address = Address.builder().address("杭州").build();
//        Dept dept = Dept.builder().name("市场部").build();
//        List<Role> roles = new ArrayList<>();
//        roles.add(Role.builder().id(1L).build());
//        roles.add(Role.builder().id(3L).build());
//        employeeDao.saveAndFlush(Employee.builder().name("胜男")
//                .birthday(new Timestamp(System.currentTimeMillis()))
//                .sex("女")
//                .address(address)
//                .dept(dept).build()
//        );

//        employeeDao.delete(2L);
//
//        employeeDao.deleteAllInBatch();
//        System.out.println(employeeDao.findAll());
    }
}
