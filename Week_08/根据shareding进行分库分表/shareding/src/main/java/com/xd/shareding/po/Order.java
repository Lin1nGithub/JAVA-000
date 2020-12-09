package com.xd.shareding.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_order")
public class Order{

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;
}
