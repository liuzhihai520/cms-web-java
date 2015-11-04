#初始化管理员
INSERT INTO t_sys_user(username,accountname,PASSWORD,salt,STATUS,createTime,description)VALUES('管理员','admin','102dccdb7330746348c46d96468ee2df','jt1d',1,NOW(),'管理员');
#初始化角色
INSERT INTO t_sys_role(NAME,roleKey,STATUS,description)VALUES('管理员','admin',1,'管理员');
#初始化管理员和角色中间表
INSERT INTO t_sys_user_role(userId,roleId)VALUES(1,1);
#初始化菜单表
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("系统 & 设置",0,'system:*',1,'system',0,'fa-desktop',1,'系统基础设置','0');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("用户管理",1,'user:userList',1,'user/userList',0,'',1,'用户管理','0/1');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("角色管理",1,'role:roleList',1,'role/roleList',0,'',1,'角色管理','0/1');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("菜单管理",1,'menu:menusList',1,'menu/menuList',0,'',1,'菜单管理','0/1');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("添加用户",2,'user:add',1,'user/addUser',0,'',1,'添加用户','0/1/2');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("更新用户",2,'user:update',1,'user/userUpdate',0,'',1,'更新用户','0/1/2');
INSERT INTO t_sys_menu(NAME,parentId,resKey,TYPE,url,LEVEL,icon,ishide,description,parent_ids)VALUES("删除用户",2,'user:delete',1,'user/userDelete',0,'',1,'删除用户','0/1/2');
#初始化角色菜单中间表
INSERT INTO t_sys_role_res(roleId,resId)VALUES(1,1);
INSERT INTO t_sys_role_res(roleId,resId)VALUES(1,2);
INSERT INTO t_sys_role_res(roleId,resId)VALUES(1,3);
INSERT INTO t_sys_role_res(roleId,resId)VALUES(1,4);