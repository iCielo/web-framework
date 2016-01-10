drop table `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`uuid`)
)