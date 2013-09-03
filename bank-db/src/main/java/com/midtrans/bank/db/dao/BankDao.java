package com.midtrans.bank.db.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BankDao<T> {
    public void save(T object);
    public void saveOrUpdate(T object);
    public void delete(T object);
    public T findBy(Long id);
    public List<T> findAll();
}
