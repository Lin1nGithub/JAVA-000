package com.xd.springbootshardingreadwrite.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class User extends Model<User> {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private int gender;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private Integer status;
}
