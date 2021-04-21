package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallIndexConfig;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallIndexConfig
 */
public interface MallIndexConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallIndexConfig record);

    int insertSelective(MallIndexConfig record);

    MallIndexConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexConfig record);

    int updateByPrimaryKey(MallIndexConfig record);

}




