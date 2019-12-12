/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import java.util.List;

/**
 * 扩展SpringDataJpa, 支持动态jpql/nativesql查询并支持分页查询
 * 使用方法：注入ServiceImpl
 *@author : wuch
 *@date: 2019/12/12
 */
public interface DynamicQuery {
    void save(Object entity);

    void update(Object entity);

    <T> void delete(Class<T> entityClass, Object entityId);

    <T> void delete(Class<T> entityClass, Object[] entityIds);

    /**
     * 查询对象列表，返回List
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryList(String nativeSql, Object... params);

    /**
     * 查询对象列表，返回List<Map<key,value>>
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListMap(String nativeSql, Object... params);

    /**
     * 查询对象列表，返回List<组合对象>
     * @param resultClass
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);


}
