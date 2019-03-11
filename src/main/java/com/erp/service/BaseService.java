package com.erp.service;

import com.erp.entity.UsersBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.erp.common.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.List;
import java.util.Set;

public abstract class BaseService<T,ID extends Serializable> {
    @Autowired
    private MyMapper<T> baseMapper;

    public T insert(T entity) {

        baseMapper.insertSelective(entity);
        return entity;
    }

    public T insertSelective(T entity) {
        baseMapper.insertSelective(entity);
        return entity;
    }

    public int delete(T entity) {
        return baseMapper.delete(entity);
    }
    public int deleteByPrimaryKey(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }



    public int updateByExample(T entity, Example example) {
        return baseMapper.updateByExample(entity, example);
    }

    public int updateByExampleSelective(T entity, Example example) {
        return baseMapper.updateByExampleSelective(entity, example);
    }




    public T queryOneByExample(Example example) {
        return baseMapper.selectOneByExample(example);
    }



    public List<T> queryByExample(Example example) {
        return baseMapper.selectByExample(example);
    }


    /*
      根据主键ID 获取数据
     */
   public T findById(ID id)
   {
      return  baseMapper.selectByPrimaryKey(id);
   }
    /*
       获取所有数据
    */
    public List<T> findAll()
    {
        return  baseMapper.selectAll();
    }




    /**
     * 自定义查询条件，分页查询
     *
     * @param example
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageListByExample(Example example, Integer page, Integer size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<T> lists = baseMapper.selectByExample(example);
        return new PageInfo<T>(lists);
    }
}