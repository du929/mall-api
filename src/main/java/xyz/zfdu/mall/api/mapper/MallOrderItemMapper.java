package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallOrderItem;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallOrderItem
 */
public interface MallOrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);

}




