CREATE TABLE `sys_dictionary` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `sort` varchar(255) NOT NULL COMMENT '分类',
  `dict_key` varchar(255) NOT NULL COMMENT '字典键',
  `dict_value` varchar(255) NOT NULL COMMENT '字典值',
  `status` varchar(50) NOT NULL COMMENT '状态：on，off',
  `seq` int(5) NOT NULL COMMENT '排序值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `op_user_id` int(36) DEFAULT NULL COMMENT '操作用户',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8