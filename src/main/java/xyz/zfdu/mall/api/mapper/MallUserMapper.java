package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallUser;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallUser
 */
public interface MallUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

}




