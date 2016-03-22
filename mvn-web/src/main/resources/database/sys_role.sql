CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '角色名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` varchar(20) DEFAULT NULL COMMENT '状态 on:启用 off:禁用',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8