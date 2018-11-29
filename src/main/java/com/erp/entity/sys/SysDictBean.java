package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.*;

    

/**
 * 数据字典表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-11-29 11:16:00
 */
@Data
@Table(name = "sys_dict")
public class SysDictBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
                @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Column(name = "id")
        private Long id;
	        //字典名称
                  @Column(name = "name")
        private String name;
	        //字典类型
                  @Column(name = "type")
        private String type;
	        //字典码
                  @Column(name = "code")
        private String code;
	        //字典值
                  @Column(name = "value")
        private String value;
	        //排序
                  @Column(name = "order_num")
        private Integer orderNum;
	        //备注
                  @Column(name = "remark")
        private String remark;
	        //删除标记  -1：已删除  0：正常
                  @Column(name = "del_flag")
        private Integer delFlag;
	
	     /**
         * 设置：
     */
     public void setId(Long id) {
            this.id = id;
      }
        /**
         * 获取：
         */
        public Long getId() {
            return id;
        }
	     /**
         * 设置：字典名称
     */
     public void setName(String name) {
            this.name = name;
      }
        /**
         * 获取：字典名称
         */
        public String getName() {
            return name;
        }
	     /**
         * 设置：字典类型
     */
     public void setType(String type) {
            this.type = type;
      }
        /**
         * 获取：字典类型
         */
        public String getType() {
            return type;
        }
	     /**
         * 设置：字典码
     */
     public void setCode(String code) {
            this.code = code;
      }
        /**
         * 获取：字典码
         */
        public String getCode() {
            return code;
        }
	     /**
         * 设置：字典值
     */
     public void setValue(String value) {
            this.value = value;
      }
        /**
         * 获取：字典值
         */
        public String getValue() {
            return value;
        }
	     /**
         * 设置：排序
     */
     public void setOrderNum(Integer orderNum) {
            this.orderNum = orderNum;
      }
        /**
         * 获取：排序
         */
        public Integer getOrderNum() {
            return orderNum;
        }
	     /**
         * 设置：备注
     */
     public void setRemark(String remark) {
            this.remark = remark;
      }
        /**
         * 获取：备注
         */
        public String getRemark() {
            return remark;
        }
	     /**
         * 设置：删除标记  -1：已删除  0：正常
     */
     public void setDelFlag(Integer delFlag) {
            this.delFlag = delFlag;
      }
        /**
         * 获取：删除标记  -1：已删除  0：正常
         */
        public Integer getDelFlag() {
            return delFlag;
        }
	
    public static class ${
                    public static String id="id";
                    public static String name="name";
                    public static String type="type";
                    public static String code="code";
                    public static String value="value";
                    public static String orderNum="orderNum";
                    public static String remark="remark";
                    public static String delFlag="delFlag";
        
    }
}
