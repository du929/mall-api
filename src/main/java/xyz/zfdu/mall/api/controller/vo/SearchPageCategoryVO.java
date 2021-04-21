package xyz.zfdu.mall.api.controller.vo;

import lombok.Data;
import xyz.zfdu.mall.api.entity.MallGoodsCategory;

import java.io.Serializable;
import java.util.List;

/**
 * @author zfdu
 * @description 搜索页面分类VO
 * @data 2021-04-21
 */
@Data
public class SearchPageCategoryVO implements Serializable {
    private String firstLevelCategoryName;
    private List<MallGoodsCategory> secondLevelCategoryList;
    private String secondLevelCategoryName;
    private List<MallGoodsCategory> thirdLevelCategoryList;
    private String currentCategoryName;
}
