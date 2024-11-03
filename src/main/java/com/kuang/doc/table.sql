CREATE DATABASE `mybatis`;

USE `mybatis`;

CREATE TABLE `user`(
                       `id` INT(20) NOT NULL PRIMARY KEY,
                       `name` VARCHAR(30) DEFAULT NULL,
                       `pwd` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`id`,`name`,`pwd`) VALUES
                                          (1,'狂神','123456'),
                                          (2,'张三','123456'),
                                          (3,'李四','123890')


CREATE TABLE `teacher` (
                           `id` INT(10) NOT NULL,
                           `name` VARCHAR(30) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO teacher(`id`, `name`) VALUES (1, '秦老师');

CREATE TABLE `student` (
                           `id` INT(10) NOT NULL,
                           `name` VARCHAR(30) DEFAULT NULL,
                           `tid` INT(10) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fktid` (`tid`),
                           CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8


INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('1', '小明', '1');
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('2', '小红', '1');
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('3', '小张', '1');
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('4', '小李', '1');
INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('5', '小王', '1');



CREATE TABLE `blog` (
                        `id` varchar(50) NOT NULL COMMENT '博客id',
                        `title` varchar(100) NOT NULL COMMENT '博客标题',
                        `author` varchar(30) NOT NULL COMMENT '博客作者',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `views` int(30) NOT NULL COMMENT '浏览量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8




CREATE TABLE `t_supplier` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                              `supCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
                              `supName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
                              `supDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商详细描述',
                              `supContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
                              `supPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
                              `supAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
                              `supFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
                              `createdUserId` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
                              `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
                              `updatedUserId` bigint(20) DEFAULT NULL COMMENT '更新时间',
                              `updatedTime` datetime DEFAULT NULL COMMENT '更新者（userId）',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES ('1', 'BJ_GYS001', '北京三木堂商贸有限公司', '长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等', '张国强', '13566667777', '北京市丰台区育芳园北路', '010-58858787', '1', '2013-03-21 16:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('3', 'GZ_GYS001', '深圳市泰香米业有限公司', '初次合作伙伴，主营产品：良记金轮米,龙轮香米等', '郑程瀚', '13402013312', '广东省深圳市福田区深南大道6006华丰大厦', '0755-67776212', '1', '2014-03-21 16:56:07', null, null);
INSERT INTO `t_supplier` VALUES ('4', 'GZ_GYS002', '深圳市喜来客商贸有限公司', '长期合作伙伴，主营产品：坚果炒货.果脯蜜饯.天然花茶.营养豆豆.特色美食.进口食品.海味零食.肉脯肉', '林妮', '18599897645', '广东省深圳市福龙工业区B2栋3楼西', '0755-67772341', '1', '2013-03-22 16:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('5', 'JS_GYS001', '兴化佳美调味品厂', '长期合作伙伴，主营产品：天然香辛料、鸡精、复合调味料', '徐国洋', '13754444221', '江苏省兴化市林湖工业区', '0523-21299098', '1', '2015-11-22 16:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('6', 'BJ_GYS002', '北京纳福尔食用油有限公司', '长期合作伙伴，主营产品：山茶油、大豆油、花生油、橄榄油等', '马莺', '13422235678', '北京市朝阳区珠江帝景1号楼', '010-588634233', '1', '2012-03-21 17:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('7', 'BJ_GYS003', '北京国粮食用油有限公司', '初次合作伙伴，主营产品：花生油、大豆油、小磨油等', '王驰', '13344441135', '北京大兴青云店开发区', '010-588134111', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `t_supplier` VALUES ('8', 'ZJ_GYS001', '慈溪市广和绿色食品厂', '长期合作伙伴，主营产品：豆瓣酱、黄豆酱、甜面酱，辣椒，大蒜等农产品', '薛圣丹', '18099953223', '浙江省宁波市慈溪周巷小安村', '0574-34449090', '1', '2013-11-21 06:02:07', null, null);
INSERT INTO `t_supplier` VALUES ('9', 'GX_GYS001', '优百商贸有限公司', '长期合作伙伴，主营产品：日化产品', '李立国', '13323566543', '广西南宁市秀厢大道42-1号', '0771-98861134', '1', '2013-03-21 19:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('10', 'JS_GYS002', '南京火头军信息技术有限公司', '长期合作伙伴，主营产品：不锈钢厨具等', '陈女士', '13098992113', '江苏省南京市浦口区浦口大道1号新城总部大厦A座903室', '025-86223345', '1', '2013-03-25 16:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('11', 'GZ_GYS003', '广州市白云区美星五金制品厂', '长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等', '梁天', '13562276775', '广州市白云区钟落潭镇福龙路20号', '020-85542231', '1', '2016-12-21 06:12:17', null, null);
INSERT INTO `t_supplier` VALUES ('12', 'BJ_GYS004', '北京隆盛日化科技', '长期合作伙伴，主营产品：日化环保清洗剂，家居洗涤专卖、洗涤用品网、墙体除霉剂、墙面霉菌清除剂等', '孙欣', '13689865678', '北京市大兴区旧宫', '010-35576786', '1', '2014-11-21 12:51:11', null, null);
INSERT INTO `t_supplier` VALUES ('13', 'SD_GYS001', '山东豪克华光联合发展有限公司', '长期合作伙伴，主营产品：洗衣皂、洗衣粉、洗衣液、洗洁精、消杀类、香皂等', '吴洪转', '13245468787', '山东济阳济北工业区仁和街21号', '0531-53362445', '1', '2015-01-28 10:52:07', null, null);
INSERT INTO `t_supplier` VALUES ('14', 'JS_GYS003', '无锡喜源坤商行', '长期合作伙伴，主营产品：日化品批销', '周一清', '18567674532', '江苏无锡盛岸西路', '0510-32274422', '1', '2016-04-23 11:11:11', null, null);
INSERT INTO `t_supplier` VALUES ('15', 'ZJ_GYS002', '乐摆日用品厂', '长期合作伙伴，主营产品：各种中、高档塑料杯，塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯', '王世杰', '13212331567', '浙江省金华市义乌市义东路', '0579-34452321', '1', '2016-08-22 10:01:30', null, null);


CREATE TABLE c_Student (
                           stu_id INT PRIMARY KEY,          -- 学生ID
                           stu_name VARCHAR(255) NOT NULL, -- 学生姓名
                           stu_age INT,                    -- 学生年龄
                           stu_salary DECIMAL(10, 2),      -- 学生薪资
                           stu_birth DATE,                  -- 出生日期
                           create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
                           course_id INT                    -- 课程ID
);


INSERT INTO c_Student (stu_id, stu_name, stu_age, stu_salary, stu_birth, create_time, course_id)
VALUES
    (1, '张三', 20, 5000.00, '2004-01-15', DEFAULT, 101),
    (2, '李四', 22, 6000.50, '2002-03-22', DEFAULT, 102),
    (3, '王五', 21, 4500.75, '2003-05-10', DEFAULT, 101),
    (4, '赵六', 23, 7000.00, '2001-07-30', DEFAULT, 103),
    (5, '孙七', 19, 4000.00, '2005-09-12', DEFAULT, 102);

