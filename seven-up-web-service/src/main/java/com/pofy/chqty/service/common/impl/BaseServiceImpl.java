package com.pofy.chqty.service.common.impl;

import com.pofy.chqty.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * function - 通用service实现类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
public class BaseServiceImpl<T> implements BaseService<T> {
    /**泛型装配*/
    @Autowired
    private Mapper<T> mapper;

    @Override
    public List<T> list(T entity) {
        return mapper.select(entity);
    }

    @Override
    public T get(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T findByPrimaryKey(String key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int update(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int save(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public int delete(T entity) {
        return mapper.delete(entity);
    }
}
