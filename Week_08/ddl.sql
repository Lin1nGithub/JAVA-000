create table `t_order`
(
    `id`             bigint    NOT NULL auto_increment comment '订单ID',
    `user_id`        bigint    NOT NULL comment '用户ID',
    `merchandise_id` bigint    NOT NULL comment '商品ID',
    `status`         tinyint comment '订单状态',
    `tradeno` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '支付交易号',
    `amount` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '订单总价',
    `expressno` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '快递单号',
    `create_time`    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '订单创建时间',
    `update_time`    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '订单更新时间',
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '订单表';