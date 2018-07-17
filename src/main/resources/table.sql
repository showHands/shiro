#用户表：

CREATE TABLE `tbUser` (
  `lId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键Id',
  `strUserName` varchar(30) NOT NULL DEFAULT '' COMMENT '用户名称',
  `strPassword` varchar(30) NOT NULL DEFAULT '' COMMENT '用户登陆密码-加密',
  `strSalt` varchar(30) NOT NULL DEFAULT '' COMMENT '盐',
  `strPhone` varchar(30) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `strEmali` varchar(30) NOT NULL DEFAULT '' COMMENT '用户邮箱账号',
  `nIdentity` int(1) DEFAULT '1' COMMENT '用户身份：1管理员，只能通过后台特殊渠道添加  2普通用户，注册或者通过excel批量导入',
  `strLogoUrl` varchar(700) NOT NULL DEFAULT '' COMMENT '默认logo',
  `nState` int(1) DEFAULT '1' COMMENT '用户状态：1注册通过待审核 2审核失败 3审核成功 4临时冻结',
  `dtCreateTime` datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `strUserName` (`strUserName`) USING BTREE,
  KEY `strPhone` (`strPhone`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

#角色表
CREATE TABLE `tbRole` (
  `lId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键Id',
  `strRole` varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
  `strDescription` varchar(30) NOT NULL DEFAULT '' COMMENT '角色描述',
  `nState` int(1) DEFAULT '1' COMMENT '角色状态：1可用 2不可用 ',
  `dtCreateTime` datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `strRole` (`strRole`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色表';


#权限表
CREATE TABLE `tbPermission` (
  `lId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键Id',
  `strPermission` varchar(30) NOT NULL DEFAULT '' COMMENT '权限名称',
  `strDescription` varchar(30) NOT NULL DEFAULT '' COMMENT '权限描述',
  `nState` int(1) DEFAULT '1' COMMENT '权限状态：1-可用  2-不可用',
  `dtCreateTime` datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `strPermission` (`strPermission`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='权限表';


#用户角色表
CREATE TABLE `tbUserRole` (
  `lId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键Id',
  `lUserId` bigint(20) NOT NULL  COMMENT '用户主键ID',
  `lRoleId` bigint(20) NOT NULL  COMMENT '角色主键ID',
  `strDescription` varchar(30) NOT NULL DEFAULT '' COMMENT '用户角色描述',
  `nState` int(1) DEFAULT '1' COMMENT '用户角色状态：1-可用  2-不可用',
  `dtCreateTime` datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  UNIQUE KEY `lUserId_lRoleId` (`lUserId`,`lRoleId`) USING BTREE,
  KEY `lUserId` (`lUserId`) USING BTREE,
  KEY `lRoleId` (`lRoleId`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

#角色权限表
CREATE TABLE `tbRolePermission` (
  `lId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键Id',
  `lPermissionId` bigint(20) NOT NULL  COMMENT '权限主键ID',
  `lRoleId` bigint(20) NOT NULL  COMMENT '角色主键ID',
  `strDescription` varchar(30) NOT NULL DEFAULT '' COMMENT '角色权限描述',
  `nState` int(1) DEFAULT '1' COMMENT '角色权限状态：1-可用  2-不可用',
  `dtCreateTime` datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `lPermissionId` (`lPermissionId`) USING BTREE,
  KEY `lRoleId` (`lRoleId`) USING BTREE,
  UNIQUE KEY `lPermissionId_lRoleId` (`lPermissionId`,`lRoleId`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

#刹车片型号brake block;
CREATE TABLE `tbBrakeBlock` (
  `lId` 				bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nType` 				int(3) NOT NULL DEFAULT 0 COMMENT '1-前刹车片  2-后刹车片',
  `strBrakeCode` 		varchar(20) NOT NULL DEFAULT '' COMMENT '刹车片型号：国际编号和自己定义的编号',
  `strStellBackingCode` varchar(20)  NOT NULL DEFAULT '' COMMENT '钢背编号',
  `strPicture1` 		varchar(200) NOT NULL DEFAULT '' COMMENT '主图、刹车片简图',
  `strPicture2` 		varchar(200) NOT NULL DEFAULT '' COMMENT '带尺寸的辅图1',
  `strPicture3` 		varchar(200) NOT NULL DEFAULT '' COMMENT  '带尺寸的辅图2',
  `strDwgNo`    		varchar(200) NOT NULL DEFAULT '' COMMENT  '图纸号',
  `strLogoUrl`  		varchar(700) NOT NULL DEFAULT '' COMMENT '默认logo',
  `dLong`       		double DEFAULT '0' COMMENT '长度',
  `dHeight`     		double DEFAULT '0' COMMENT '宽度',
  `dThickness`  		double DEFAULT '0' COMMENT '厚度',
  `dtCreateTime` 		datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` 		datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `strStellBackingCode` (`strStellBackingCode`) USING BTREE,
  KEY `strBrakeCode` (`strBrakeCode`) USING BTREE,
  KEY `nType_strBrakeCode` (`nType`,`strBrakeCode`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=utf8 COMMENT='钢背|刹车片表';



#产品表
CREATE TABLE `tbCarModel` (
  `lId` 				bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `strBrandName` 		varchar(30) NOT NULL DEFAULT '' COMMENT '品牌',
  `lBrandId` 			varchar(30) NOT NULL DEFAULT '' COMMENT '',
  `strOfYear` 			varchar(10) NOT NULL DEFAULT '' COMMENT '年份: 1997-2014：表示年份在1997-2014的车型使用的刹车片 ； 2015-：2015年截至到目前位置的车型使用的刹车片型号',
  `strCarModelName` 	varchar(30) NOT NULL DEFAULT '' COMMENT '车型',
  `strFrontBrakeCode` 		varchar(30) NOT NULL DEFAULT '' COMMENT '前刹车片编号，为空表示没有',
  `strBackBrakeCode` 		varchar(30) NOT NULL DEFAULT '' COMMENT '后刹车片编号',
  `dtCreateTime` 		datetime NOT NULL COMMENT '创建时间',
  `dtModifyTime` 		datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`lId`),
  KEY `strUserName` (`strUserName`) USING BTREE,
  KEY `strPhone` (`strPhone`) USING BTREE,
  KEY `nState` (`nState`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=utf8 COMMENT='用户表';


产品搜索功能：
按照品牌-车型-年代  三级联动来搜索


钢被尺寸表中钢被编号=车型目录中的前后刹车片编号

