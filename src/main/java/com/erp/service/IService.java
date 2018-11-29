package com.erp.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

public interface IService<T,ID extends Serializable> {


    /*
       强制插入
     */
     T insert(T entity);

    /*
       选择性插入
   */
     T insertSelective(T entity);

     int delete(T entity);

     int deleteByPrimaryKey(ID id);


     int updateByPrimaryKey(T entity);


     int updateByPrimaryKeySelective(T entity);




     int updateByExample(T entity, Example example);


     int updateByExampleSelective(T entity, Example example);



     T queryOneByExample(Example example);




     List<T> queryByExample(Example example);


    /*
      根据主键ID 获取数据
     */

     T findById(ID id);
    /*
       获取所有数据
    */

     List<T> findAll();
    /**
     * 自定义查询条件，分页查询
     *
     * @param example
     * @param page
     * @param rows
     * @return
     */

     PageInfo<T> queryPageListByExample(Example example, Integer page, Integer rows);
}
