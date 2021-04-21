package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallGoodsInfo;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallGoodsInfo
 */
public interface MallGoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsInfo record);

    int insertSelective(MallGoodsInfo record);

    MallGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsInfo record);

    int updateByPrimaryKey(MallGoodsInfo record);

}




