package xyz.zfdu.mall.api.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zfdu
 * @description 保存订单param
 * @data 2021-04-21
 */
@Data
public class SaveOrderParam implements Serializable {
    @ApiModelProperty("订单项id数组")
    private Long[] cartItemIds;
    @ApiModelProperty("地址id")
    private Long addressId;
}
