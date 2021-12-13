package com.feng.springboot;

import com.feng.springboot.entity.Items;
import com.feng.springboot.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
   private TestMapper testMapper;

    @Test
    public  void  test(){
        System.out.println("==========================");
        
        List<Items> items = testMapper.selectList(null);
        for (Items a:items){
            System.out.println(a);
        }
    }
}
