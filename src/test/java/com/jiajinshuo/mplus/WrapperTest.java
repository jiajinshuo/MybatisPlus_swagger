package com.jiajinshuo.mplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiajinshuo.mplus.mapper.UserMapper;
import com.jiajinshuo.mplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiajinshuo
 * @create 2020-05-18 10:23
 */
@SpringBootTest
public class WrapperTest {


    @Autowired(required = false)
    private UserMapper userMapper;
    /**
     * 测试查询name和eamail不为空并且age大于18的用户
     */
    @Test
    public void testWrapper(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",18);

        userMapper.selectList(qw).forEach(System.out::println);


    }
}
