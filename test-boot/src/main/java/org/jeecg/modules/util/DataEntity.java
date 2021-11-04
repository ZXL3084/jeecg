package org.jeecg.modules.util;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: DataEntity
 * @Description: 数据Entity类
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

//    @TableField(value = "create_id", fill = FieldFill.INSERT)
//    private String createId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "valid", fill = FieldFill.INSERT)
    @TableLogic(value="0",delval = "1")
    private Integer valid; // 删除标记 1：已删除 0：正常

}
