package org.jeecg.modules.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.junit.platform.commons.util.StringUtils;

import java.io.Serializable;

@Data
@ApiModel("分页请求基类")
@NoArgsConstructor
@SuperBuilder
public class BasePageListReq implements Serializable {

    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    @ApiModelProperty("每页大小")
    private Integer pageSize = 10;

    @ApiModelProperty("排序字段（多字段排序以逗号分割）")
    private String orderField;

    @ApiModelProperty("排序方式 （asc 或 desc）")
    private String order;

    public String getOrderBy(){
        if(StringUtils.isBlank(orderField)){
            return null;
        }
        if(order==null){
            order="desc";
        }
        return orderField+" "+order;
    }
}
