package xyz.zfdu.mall.api.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zfdu
 * @description 修改购物项param
 * @data 2021-04-21
 */
@Data
public class UpdateCartItemParam implements Serializable {
    @ApiModelProperty("购物项id")
    private Long cartItemId;
    @ApiModelProperty("商品数量")
    private Integer goodsCount;
}
