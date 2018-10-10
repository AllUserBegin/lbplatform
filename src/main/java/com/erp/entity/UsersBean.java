package com.erp.entity;


import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



@Data
@Table(name = "users")
public class UsersBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    private Long userid;
    //用户名称
    private String username;
    //用户密码
    private String userpwd;
    //用户邮箱
    private String useremail;
    //年龄
    private Integer age;
    //出生日期
    private Date borndate;
    //入库时间
    private Date createtime;
    //修改时间
    private Date modifytime;
    //是否删除 0未删 1 删除
    private Boolean isdel;
    //用户状态 0待审核  5审核不通过 10审核通过
    private Integer userstatus;

    /**
     * 设置：用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    /**
     * 获取：用户ID
     */
    public Long getUserid() {
        return userid;
    }
    /**
     * 设置：用户名称
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 获取：用户名称
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：用户密码
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    /**
     * 获取：用户密码
     */
    public String getUserpwd() {
        return userpwd;
    }
    /**
     * 设置：用户邮箱
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    /**
     * 获取：用户邮箱
     */
    public String getUseremail() {
        return useremail;
    }
    /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return age;
    }
    /**
     * 设置：出生日期
     */
    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }
    /**
     * 获取：出生日期
     */
    public Date getBorndate() {
        return borndate;
    }
    /**
     * 设置：入库时间
     */
    public void setAddtime(Date addtime) {
        this.createtime = addtime;
    }
    /**
     * 获取：入库时间
     */
    public Date getAddtime() {
        return createtime;
    }
    /**
     * 设置：修改时间
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
    /**
     * 获取：修改时间
     */
    public Date getModifytime() {
        return modifytime;
    }
    /**
     * 设置：是否删除 0未删 1 删除
     */
    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }
    /**
     * 获取：是否删除 0未删 1 删除
     */
    public Boolean getIsdel() {
        return isdel;
    }
    /**
     * 设置：用户状态 0待审核  5审核不通过 10审核通过
     */
    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }
    /**
     * 获取：用户状态 0待审核  5审核不通过 10审核通过
     */
    public Integer getUserstatus() {
        return userstatus;
    }
}
