package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallShoppingCartItem;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallShoppingCartItem
 */
public interface MallShoppingCartItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    MallShoppingCartItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

}




