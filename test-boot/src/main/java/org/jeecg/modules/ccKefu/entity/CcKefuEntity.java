package org.jeecg.modules.ccKefu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecg.modules.util.DataEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
public class CcKefuEntity extends DataEntity {



    /**
     * 所属部门
     */
    @TableField(value = "sys_org_code")
    private String sysOrgCode;

    /**
     * 客服名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 生日
     */
    @TableField(value = "birth")
    private Date birth;

    /**
     * 描述
     */
    @TableField(value = "context")
    private String context;


}
