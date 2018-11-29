package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.*;

    

/**
 * 定时任务
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-11-29 09:14:40
 */
@Data
@Table(name = "schedule_job")
public class ScheduleJobBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //任务id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Column(name = "job_id")
        private Long jobId;
	        //spring bean名称
          @Column(name = "bean_name")
        private String beanName;
	        //方法名
          @Column(name = "method_name")
        private String methodName;
	        //参数
          @Column(name = "params")
        private String params;
	        //cron表达式
          @Column(name = "cron_expression")
        private String cronExpression;
	        //任务状态  0：正常  1：暂停
          @Column(name = "status")
        private Integer status;
	        //备注
          @Column(name = "remark")
        private String remark;
	        //创建时间
          @Column(name = "create_time")
        private Date createTime;
	
	     /**
         * 设置：任务id
     */
     public void setJobId(Long jobId) {
            this.jobId = jobId;
      }
        /**
         * 获取：任务id
         */
        public Long getJobId() {
            return jobId;
        }
	     /**
         * 设置：spring bean名称
     */
     public void setBeanName(String beanName) {
            this.beanName = beanName;
      }
        /**
         * 获取：spring bean名称
         */
        public String getBeanName() {
            return beanName;
        }
	     /**
         * 设置：方法名
     */
     public void setMethodName(String methodName) {
            this.methodName = methodName;
      }
        /**
         * 获取：方法名
         */
        public String getMethodName() {
            return methodName;
        }
	     /**
         * 设置：参数
     */
     public void setParams(String params) {
            this.params = params;
      }
        /**
         * 获取：参数
         */
        public String getParams() {
            return params;
        }
	     /**
         * 设置：cron表达式
     */
     public void setCronExpression(String cronExpression) {
            this.cronExpression = cronExpression;
      }
        /**
         * 获取：cron表达式
         */
        public String getCronExpression() {
            return cronExpression;
        }
	     /**
         * 设置：任务状态  0：正常  1：暂停
     */
     public void setStatus(Integer status) {
            this.status = status;
      }
        /**
         * 获取：任务状态  0：正常  1：暂停
         */
        public Integer getStatus() {
            return status;
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
         * 设置：创建时间
     */
     public void setCreateTime(Date createTime) {
            this.createTime = createTime;
      }
        /**
         * 获取：创建时间
         */
        public Date getCreateTime() {
            return createTime;
        }
	
    public static class ${
                    public static String jobId="jobId";
                    public static String beanName="beanName";
                    public static String methodName="methodName";
                    public static String params="params";
                    public static String cronExpression="cronExpression";
                    public static String status="status";
                    public static String remark="remark";
                    public static String createTime="createTime";
        
    }
}
