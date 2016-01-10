drop table `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT 'uuid主键',
  `account` varchar(200) DEFAULT NULL COMMENT '账号',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`uuid`)
)