package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallUserAddress;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallUserAddress
 */
public interface MallUserAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    MallUserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);

}




