package com.learn.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
