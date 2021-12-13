package com.feng.springboot.Service;

import com.feng.springboot.entity.Carousel;

import java.util.Calendar;
import java.util.List;

public interface CarouselService {

    List<Carousel> queryAll(Integer isShow);
}
