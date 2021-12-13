package com.feng.springboot.Service.ServiceImpl;

import com.feng.springboot.Service.CarouselService;
import com.feng.springboot.entity.Carousel;
import com.feng.springboot.mapper.CarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria isShow1 = example.createCriteria().andEqualTo("isShow", isShow);
        List<Carousel> carousels = carouselMapper.selectByExample(example);

        return carousels;
    }
}
