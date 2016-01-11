drop table `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `resource_code` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
)