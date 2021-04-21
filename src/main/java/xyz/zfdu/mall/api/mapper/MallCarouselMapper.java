package xyz.zfdu.mall.api.mapper;

import xyz.zfdu.mall.api.entity.MallCarousel;

/**
 * @Entity xyz.zfdu.mall.api.entity.MallCarousel
 */
public interface MallCarouselMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallCarousel record);

    int insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

}




