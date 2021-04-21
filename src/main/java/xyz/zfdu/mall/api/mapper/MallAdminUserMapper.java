package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallAdminUser;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallAdminUser
 */
public interface MallAdminUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallAdminUser record);

    int insertSelective(MallAdminUser record);

    MallAdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallAdminUser record);

    int updateByPrimaryKey(MallAdminUser record);

}




