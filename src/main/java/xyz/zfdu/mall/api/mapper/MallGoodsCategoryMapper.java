package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallGoodsCategory;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallGoodsCategory
 */
public interface MallGoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsCategory record);

    int insertSelective(MallGoodsCategory record);

    MallGoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsCategory record);

    int updateByPrimaryKey(MallGoodsCategory record);

}




