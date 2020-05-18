package com.jiajinshuo.mplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiajinshuo.mplus.mapper.UserMapper;
import com.jiajinshuo.mplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MplusApplicationTests {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> users =userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    // 测试批量查询
    @Test
    public void testSelect(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    // 测试map条件查询
    @Test
    public void testMapSelect(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","shadiao");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }
    // 测试分页查询
    @Test
    public void testPage(){
        // 第一页，每页三条
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);

    }

    //测试插入
    @Test
    public void  testInsert(){
        User user = new User();
        user.setAge(18);
        user.setEmail("weige@qq.com");
        user.setName("weige");

        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);

    }
    // 测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1262011010319249410L);
        user.setName("tomdog");

        userMapper.updateById(user);
    }
    // 测试删除
    @Test
    public void testDelete(){
        userMapper.deleteById(1);
    }

}
