package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallUserToken;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallUserToken
 */
public interface MallUserTokenMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUserToken record);

    int insertSelective(MallUserToken record);

    MallUserToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserToken record);

    int updateByPrimaryKey(MallUserToken record);

    MallUserToken selectByToken(String token);
}




