package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.logic.dao.BankDao;
import org.hibernate.Criteria;
import org.jpos.ee.DB;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBankDao<T> implements BankDao<T> {
    protected Class<T> domainClass = getDomainClass();
    protected DB db;

    protected AbstractBankDao(DB db) {
        this.db = db;
    }

    @Override
    public void save(T object) {
        db.save(object);
    }

    @Override
    public void saveOrUpdate(T object) {
        db.saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {
        db.delete(object);
    }

    @Override
    public T findBy(Long id) {
        return (T) db.session().get(domainClass, id);
    }

    @Override
    public List<T> findAll() {
        Criteria criteria = db.session().createCriteria(domainClass);
        return criteria.list();
    }

    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
}
