package com.jiajinshuo.mplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jiajinshuo
 * @create 2020-05-17 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    //  逻辑删除注解
    @TableLogic
    private Integer deleted;
    // 乐观锁的注解
    @Version
    private Integer version;
    // 插入时填充
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    // 插入和更新时填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
