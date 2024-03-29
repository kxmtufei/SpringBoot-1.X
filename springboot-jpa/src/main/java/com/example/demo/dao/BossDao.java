/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Boss;
import com.example.demo.bean.BossAndCar;
import com.example.demo.bean.BossCarVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *  JpaRepository<对象名，主键类型>
 *@author : wuch
 *@date: 2019/11/27
 */
public interface BossDao extends JpaRepository<Boss,Integer> {
    //自定义简单查询，根据方法名来自动生成 SQL，主要的语法是 findXXBy, readAXXBy, queryXXBy, countXXBy, getXXBy， deleteBy
    Boss findByBrand(String Brand);
    //关键字 And、 Or
    List<Boss> getByNameOrBrand(String name, String brand);
    //统计
    int countByAssets(BigDecimal assets);
    //LIKE、 IgnoreCase、 OrderBy
    List<Boss> findByNameLike(String name);
    //查找id>=? 按assets降序
    List<Boss> queryByIdGreaterThanEqualOrderByAssetsDesc(Integer id);

    //分页查询
    Page<Boss> findByNameLike(String name , Pageable pageable);

    //限制查询(只需要查询前N个元素，或者支取前一个实体)
    Boss findFirstByOrderByAssetsDesc();
    Boss findTopByOrderByAssetsAsc();
    Page<Boss> queryFirst3ByIdGreaterThanEqual(Integer id, Pageable pageable);
    List<Boss> findFirst2ByIdGreaterThanEqual(Integer id, Sort sort);
    List<Boss> queryTop3ByIdGreaterThanEqual(Integer id, Pageable pageable);

    //自定义简单查询，注解方式
//    在 SQL 的查询方法上面使用 @Query注解，如涉及到删除和修改在需要加上 @Modifying.也可以根据需要添加 @Transactional对事物的支持，查询超时的设置
    @Transactional
    @Modifying
    @Query("update Boss b set b.name = :name,b.brand = :brand,b.assets = :assets where b.id =:id")// 命名参数（推荐）采用@Param("参数名")，而不用管顺序
    int updateById(@Param("name") String name, @Param("brand")String brand, @Param("assets")BigDecimal assets, @Param("id")Integer id);

    @Transactional
    @Modifying
    @Query("delete from Boss where id = ?1")//利用下标索引传参
    void deleteById(Integer id);

    @Transactional(timeout = 10)//默认为秒，默认与数据库相同，mysql默认为10
    @Query(value = "select * from  t_boss",nativeQuery = true)//使用原生的SQL查询
    List<Boss> findAllBoss();

    // 多表查询


    // 第一种是利用 Hibernate 的级联查询来实现，

    // 第二种是创建一个结果集的接口来接收连表查询后的结果，无法使用其他链接
    @Query("select b.id as id,b.name as name,b.brand as brand,c.name as cname from Boss b,Car c where c.bid = b.id and b.id > ?1")
    List<BossAndCar> findBossAndCar(Integer id);
    //使用sql
    @Query(value = "select b.id,b.name ,c.cname,b.brand  from t_boss b left join t_car c on c.bid = b.id", nativeQuery = true)
    //Jpa无法自动完成查询结果到自定义实体的映射,，所以我们要使用改对象接收,然后使用自定义工具进行对象转换
    List<Object[]> findBossAndCarSql();

}
