CREATE TABLE `sys_user` (
                            `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                            `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
                            `user_name` varchar(30) NOT NULL COMMENT '用户账号',
                            `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
                            `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
                            `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
                            `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '手机号码',
                            `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
                            `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
                            `password` varchar(100) DEFAULT '' COMMENT '密码',
                            `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
                            `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';