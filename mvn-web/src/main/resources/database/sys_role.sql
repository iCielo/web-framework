drop table `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL COMMENT 'uuid主键标志',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(255) DEFAULT '1' COMMENT '状态',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
)