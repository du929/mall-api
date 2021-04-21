package xyz.zfdu.mall.api.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zfdu
 * @description 购物项VO
 * @data 2021-04-21
 */
@Data
public class MallShoppingCartItemVO implements Serializable {
    @ApiModelProperty("购物项id")
    private Long cartItemId;
    @ApiModelProperty("商品id")
    private Long goodsId;
    @ApiModelProperty("商品数量")
    private Integer goodsCount;
    @ApiModelProperty("商品名称")
    private String goodsName;
    @ApiModelProperty("商品图片")
    private String goodsCoverImg;
    @ApiModelProperty("商品价格")
    private Integer sellingPrice;
}
