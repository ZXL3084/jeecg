package org.jeecg.modules.ccKefu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jeecg.modules.util.DataEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zxl
 * @since 2021-11-03
 */
@TableName("cc_kefu")
public class CcKefuEntity extends DataEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 所属部门
     */
    private String sysOrgCode;

    /**
     * 客服名字
     */
    private String name;

    /**
     * 年龄
     */
//    实体字段加注解
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // 敏感字段
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private LocalDateTime birth;

    /**
     * 描述
     */
    private String context;

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }



    @Override
    public String toString() {
        return "CcKefuEntity{" +
            ", sysOrgCode=" + sysOrgCode +
            ", name=" + name +
            ", age=" + age +
            ", sex=" + sex +
            ", birth=" + birth +
            ", context=" + context +
        "}";
    }
}
