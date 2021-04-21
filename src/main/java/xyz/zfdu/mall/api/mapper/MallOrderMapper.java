package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallOrder;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallOrder
 */
public interface MallOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);

}




