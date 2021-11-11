package org.jeecg.modules.ccKefu.req;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.modules.util.BasePageListReq;


/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-03
 * @Description:
 */
@Data
public class KeFuPageListReq extends BasePageListReq {


    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("性别")
    private String sex;
}
