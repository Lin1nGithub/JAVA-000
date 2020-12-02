create table `t_merchandise`
(
    `id`          bigint  NOT NULL auto_increment comment 'id',
    `name`        varchar(255)       DEFAULT NULL comment '商品名称',
    `price`       double comment '商品价格',
    `status`      tinyint comment '商品状态',
    `description` TEXT COMMENT '商品描述',
    `istui` ENUM('0', '1') NOT NULL DEFAULT '0' COMMENT '是否推荐',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (`id`)
) engine = InnoDB
  default CHARSET = utf8 comment '商品表';

create table `t_user`
(
    `id`          bigint    NOT NULL auto_increment comment '用户id',
    `name`        varchar(255)       DEFAULT NULL comment '用户名',
    `gender`      tinyint            DEFAULT NULL comment '用户性别',
    `mobile`      varchar(20)            DEFAULT NULL comment '用户手机号',
    `email`      varchar(255)            DEFAULT NULL comment '用户邮箱',
    `status`      tinyint comment '用户状态',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '用户创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '用户更新时间',
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 comment '用户表';

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
  DEFAULT CHARSET = utf8 comment '订单表';