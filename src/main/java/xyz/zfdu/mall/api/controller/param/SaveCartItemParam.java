package xyz.zfdu.mall.api.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zfdu
 * @description 添加购物项param
 * @data 2021-04-21
 */
@Data
public class SaveCartItemParam implements Serializable {
    @ApiModelProperty("商品数量")
    private Integer goodsCount;
    @ApiModelProperty("商品id")
    private Long goodsId;

}
