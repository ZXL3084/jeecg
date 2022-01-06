package org.jeecg.modules.ccKefu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.jeecg.modules.util.DataEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zxl
 * @since 2021-11-15
 */
@Data
@TableName("cc_kefu")
//@XmlRootElement  //配置xml的根元素
public class CcKefuEntity extends DataEntity {



    /**
     * 所属部门
     */
    @TableField(value = "sys_org_code")
    //@XmlElement
    private String sysOrgCode;

    /**
     * 客服名字
     */
    @TableField(value = "name")
    //@XmlElement
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    //@XmlElement
    private Integer age;

    /**
     * 性别
     */
    @TableField(value = "sex")
    //@XmlElement
    private String sex;

    /**
     * 生日
     */
    @TableField(value = "birth")
//    @JSONField(format = "yyyy年MM月dd日")   //fastjson所提供
    @JsonFormat(pattern = "yyyy年MM月dd日") //fastjson所提供
    //@XmlElement
    private Date birth;

    /**
     * 描述
     */
    @TableField(value = "context")
    //@XmlElement
    private String context;




}
