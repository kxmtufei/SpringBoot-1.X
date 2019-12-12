/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao.impl;

import com.example.demo.dao.DynamicQuery;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *  动态jpql/nativesql查询的实现类
 *@author : wuch
 *@date: 2019/12/12
 */
@Repository
public class DynamicQueryImpl implements DynamicQuery {
    Logger logger = LoggerFactory.getLogger(DynamicQueryImpl.class);

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Object entity) {
        em.persist(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Object entity) {
        em.merge(entity);
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object entityId) {
        delete(entityClass, new Object[]{entityId});
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object[] entityIds) {
        for (Object id : entityIds) {
            em.remove(em.getReference(entityClass, id));
        }
    }

    private Query createNativeQuery(String sql, Object... params){
        Query q = em.createNativeQuery(sql);
        if (params != null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i+1, params[i]);
            }
        }
        return q;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQueryList(String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.TO_LIST);
        return q.getResultList();
}

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQueryListMap(String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(resultClass));
        return q.getResultList();
    }
}
