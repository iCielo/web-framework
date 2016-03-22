CREATE TABLE `sys_resource` (
  `code` varchar(255) NOT NULL COMMENT '资源码',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(255) DEFAULT NULL COMMENT '资源链接地址',
  `parent_code` varchar(255) DEFAULT NULL COMMENT '父资源',
  `type` int(11) DEFAULT NULL COMMENT '类型 1：菜单 2：功能码',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8