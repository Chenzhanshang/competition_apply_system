/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.40 : Database - db_competitionapply
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_competitionapply` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_competitionapply`;

/*Table structure for table `t_advice` */

DROP TABLE IF EXISTS `t_advice`;

CREATE TABLE `t_advice` (
  `advice_id` varchar(48) NOT NULL,
  `user_id` varchar(48) DEFAULT NULL,
  `advice_type` varchar(48) DEFAULT NULL,
  `advice_state` int(11) DEFAULT NULL,
  `advice_content` varchar(255) DEFAULT NULL,
  `advice_date` bigint(20) DEFAULT NULL,
  `dispose_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`advice_id`),
  KEY `FK_T_ADVISE_REFERENCE_T_USER` (`user_id`),
  CONSTRAINT `FK_T_ADVISE_REFERENCE_T_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_advice` */

insert  into `t_advice`(`advice_id`,`user_id`,`advice_type`,`advice_state`,`advice_content`,`advice_date`,`dispose_time`) values ('05c0b9b7-8898-479c-acbc-beee3196c044','5','建议',0,'这是一条反馈消息',1587308684428,NULL),('137c8490-0aef-41cf-9bda-c545dfc805bb','4','建议',0,'界面不够美观，可以适调整',1587308519468,NULL),('3415d919-48ae-4d55-ab71-f5f0f5873c05','1','投诉',1,'test',1583223626376,1583296206198),('48aae1e3-3367-44a3-b65e-0c7a00597513','1','建议',1,'可以适当的优化界面',1585364014719,1588843484009),('6cf72681-0103-413a-977d-83804c7f0f6c','7','建议',1,'这是一条反馈信息',1587309221238,1590327849748),('76c77d07-e0b7-48a1-a938-21d0e9a89772','7','建议',0,'界面可以加个背景图',1587309197731,NULL),('9fe63efe-886a-4a53-8ad0-aa60d26a779b','2','建议',1,'李四的建议',1587359243459,1587359654667),('a744c548-3c3c-4755-8ab0-c4b294457597','1','建议',1,'test',1583223544273,1583296217273),('ab2d535c-6c33-4337-88ad-101b74cb9f99','1','投诉',0,'系统卡顿严重',1585363988049,NULL),('b135f0de-7cbf-4c50-ae56-d135c917bec8','5','投诉',0,'无聊发条反馈',1587308657465,NULL),('ba539aef-282b-4a8f-b9c4-f967933ca5ed','1','投诉',1,'系统反应太慢',1583220537033,1583303380324),('cd81b494-8399-4f9e-9a0d-1f57f7b85d83','6','投诉',0,'系统反应太慢',1587308812166,NULL),('d6309359-1e3d-4f54-b05c-68ed82f99939','1','投诉',0,'投诉未处理',1585364153661,NULL),('d90135ed-bbc7-4bca-a64c-e161e60d2d12','5','投诉',0,'有人比赛作弊，希望加强管理',1587308633524,NULL),('e944bc89-7be0-4071-a19c-fff51a439778','1','投诉',1,'666',1583220651978,1583296229035),('f3590d50-fc18-4ef8-a00d-8ef715edf5fc','4','建议',0,'用户少，可以适当宣传',1587308546697,NULL),('f3a4e994-3eb4-4a9c-99e0-6f0205ea050f','1','投诉',1,'由用户作弊',1583220710451,1585363292979),('fa6b497b-cfd7-42bb-99c2-5f5932a363a7','6','建议',0,'组队功能希望可以看到队长联系方式',1587308846607,NULL);

/*Table structure for table `t_apply` */

DROP TABLE IF EXISTS `t_apply`;

CREATE TABLE `t_apply` (
  `apply_id` varchar(48) NOT NULL,
  `apply_time` bigint(20) DEFAULT NULL,
  `apply_content` varchar(255) DEFAULT NULL,
  `apply_state` int(11) DEFAULT NULL,
  `team_id` varchar(48) DEFAULT NULL,
  `user_id` varchar(48) DEFAULT NULL,
  `apply_dispose_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `FK_T_APPLY_REFERENCE_T_TEAM` (`team_id`),
  KEY `FK_T_APPLY_REFERENCE_T_USER` (`user_id`),
  CONSTRAINT `FK_T_APPLY_REFERENCE_T_TEAM` FOREIGN KEY (`team_id`) REFERENCES `t_team` (`team_id`),
  CONSTRAINT `FK_T_APPLY_REFERENCE_T_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_apply` */

insert  into `t_apply`(`apply_id`,`apply_time`,`apply_content`,`apply_state`,`team_id`,`user_id`,`apply_dispose_time`) values ('008714b2-9e96-4de3-9e0e-70ed9b7d1e39',1587306605813,'张四申请',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','8',NULL),('01328f30-7ac3-430b-900a-b8ede7c33405',1587306618523,'张四申请',1,'a179c7ce-0937-48f7-a815-faa2c4647cab','8',1587308122252),('0464c1de-ab95-4da3-ad80-152f854204e9',1587306517001,'田七想加入',1,'a9659f7f-81a2-4239-b4e1-a668408f8cd2','6',1589001288703),('04cf88d5-5c98-4c21-8437-950422d03087',1587306321271,'王五申请加入',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','4',1587307812919),('063e38f8-7759-49bf-9374-8a0d58815b3d',1587306549379,'王八加入申请',1,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','7',1587307829327),('09dccb56-d268-4b84-b17f-e7aac2685652',1587306554926,'王八加入申请',1,'967fbba4-1a3e-49eb-87ab-243e9982ace5','7',1587307862034),('0a7cd6d2-9aaf-4f56-a55d-a0a1b03724ee',1587306515470,'田七想加入',1,'a179c7ce-0937-48f7-a815-faa2c4647cab','6',1587308093504),('0aa04ddc-8896-4131-90b3-c3d3e88f3a47',1587306716752,'赵一的加入申请',1,'967fbba4-1a3e-49eb-87ab-243e9982ace5','10',1587307866646),('0b300fca-ffa8-4dc5-b194-b3fbb5f96fc7',1587306129466,'李四申请加入口语大队',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','3',1587307868716),('0d4cb54c-ccbc-4865-bb49-5e5a043ce804',1587306718924,'赵一的加入申请',0,'99738531-a3c7-4378-9feb-7a676a4c69af','10',NULL),('0d7ae859-2956-49af-9fa6-f6c4ccb7bc99',1587306665990,'陈六想加入',1,'99738531-a3c7-4378-9feb-7a676a4c69af','9',1589001296810),('113c7f95-868c-4f2f-ac03-5b647dedfe53',1587306658463,'陈六想加入',1,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','9',1587307835522),('1178214e-5412-4967-bda6-2f03313c54e3',1587306556424,'王八加入申请',0,'99738531-a3c7-4378-9feb-7a676a4c69af','7',NULL),('1280224c-ce0e-4019-8e64-ff89a4550ca5',1587306610549,'张四申请',0,'72fd7591-87e5-411f-8b09-08bb34a26bac','8',NULL),('2055527e-ad5c-4700-af10-9d52ca9a3687',1587306722238,'赵一的加入申请',0,'a9659f7f-81a2-4239-b4e1-a668408f8cd2','10',NULL),('2202637d-cc81-4c9f-ae6b-d2a72cc02627',1587306616479,'张四申请',0,'99738531-a3c7-4378-9feb-7a676a4c69af','8',NULL),('23ab4833-97b8-4062-9fbb-597f6d167549',1587306112428,'李四申请加入数学建模队',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','3',1587307836865),('2b2c8207-fc2c-4bcc-b4d1-06c98551757b',1587306464154,'赵六申请加入',1,'82ce95ce-a063-4835-9286-3c9cafea4270','5',1587308282403),('2bc9615e-0b5c-4065-afd1-ce111ad1424c',1587306466955,'赵六申请加入',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','5',1587307869762),('2e307bad-0149-4bef-83af-80016c6e2e80',1587306607488,'张四申请',0,'2d69c453-e7e4-444d-b806-57147cbc6e34','8',NULL),('30873750-1d4a-45dc-b58d-e95470c1b286',1587307664336,'申请加入张四英语知识队',2,'d57ea0cf-3079-4dbe-a8c5-3e41f9c4774f','1',1587307680786),('3217fcd7-8a03-4281-b90e-f35b1abd2318',1587306512578,'田七想加入',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','6',1587307870932),('325c3bad-9b01-4993-b411-7d0a69605708',1587306511008,'田七想加入',1,'82ce95ce-a063-4835-9286-3c9cafea4270','6',1587308112447),('3a66ace8-6e2e-4b8f-87fb-54cb0e7f047d',1587306559825,'王八加入申请',0,'a9659f7f-81a2-4239-b4e1-a668408f8cd2','7',NULL),('45a3bfd7-81ce-421f-89ac-7c63ffa4f3be',1587306613506,'张四申请',0,'82ce95ce-a063-4835-9286-3c9cafea4270','8',NULL),('473b0591-4eef-4a74-86ed-ebd6d8c61ac9',1587306609033,'张四申请',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','8',1587307839684),('492178ba-08d9-4c0a-abee-48449833b79d',1587306322854,'王五申请加入',2,'a179c7ce-0937-48f7-a815-faa2c4647cab','4',1587308280147),('55730678-23af-4621-a4d6-650aa2df4b29',1587306664608,'陈六想加入',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','9',1587307872116),('5864ca90-b9b6-4a69-b392-50dfbb755d99',1587306508331,'田七想加入',0,'72fd7591-87e5-411f-8b09-08bb34a26bac','6',NULL),('5a8509f8-376f-4390-a472-fb1322ce2c44',1587306319603,'王五申请加入',0,'82ce95ce-a063-4835-9286-3c9cafea4270','4',NULL),('5b30ac95-9eb7-45b7-bec3-d8b19800b676',1587306659849,'陈六想加入',0,'72fd7591-87e5-411f-8b09-08bb34a26bac','9',NULL),('6453bee2-049b-450b-b6e5-804e03da8959',1587306547942,'王八加入申请',0,'2d69c453-e7e4-444d-b806-57147cbc6e34','7',NULL),('65129494-81c3-42a7-a11e-ec9bbc72633a',1590328068590,'111',1,'1bfc9d8a-7485-4319-85ac-ec074f6366fd','1',1590328083447),('654fb40a-71a0-4cff-ac29-f8b20ee5faa0',1587306623142,'张四申请',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','8',1587308285097),('67ab061a-d3ca-4735-81cc-2691587d414c',1587306155127,'李四申请加入张三口语队',1,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','3',1587308048535),('6be0c442-a350-4353-b626-3f19489ff2b1',1587306460856,'赵六申请加入',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','5',NULL),('6fd4e298-8500-4617-85ca-c9c76fce0adf',1587307751171,'申请加入',1,'b7996c26-bf12-409f-9347-d190f83f4c8d','1',1587307773220),('70aa5f42-b71b-433e-b024-f6169a0fa59f',1587306470097,'赵六申请加入',1,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','5',1587308041969),('74d37166-75f7-4995-a334-845dac2b2b1d',1587306507007,'田七想加入',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','6',1587307841795),('7f9b7df7-502e-4033-a3c4-543cdf22bafd',1587306143769,'李四申请加入数学建模张三队',2,'a179c7ce-0937-48f7-a815-faa2c4647cab','3',1587308286900),('87490df2-4fce-46d4-9dd8-08072f1fd1b0',1587306706345,'赵一的加入申请',0,'2d69c453-e7e4-444d-b806-57147cbc6e34','10',NULL),('8800490a-4e73-4c2c-8337-bb20ffa9e980',1590327921246,'申请信息',0,'17527ebf-6d41-44ed-869e-bd5650c08efc','1',NULL),('91d47c41-8df4-468b-bdf3-de9a0ae17e04',1587306558156,'王八加入申请',2,'a179c7ce-0937-48f7-a815-faa2c4647cab','7',1587308287569),('9542ea1b-fa47-4fc0-9937-a61c9a493727',1587306657030,'陈六想加入',0,'2d69c453-e7e4-444d-b806-57147cbc6e34','9',NULL),('96c9e90a-07c4-42bc-8b32-a5337bb186a5',1587306704589,'赵一的加入申请',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','10',NULL),('99309b06-8204-411d-b437-1027bd9cda09',1587305787542,'希望加入一起玩耍',0,'82ce95ce-a063-4835-9286-3c9cafea4270','1',NULL),('a50e8463-285c-490b-8a4b-3aae0ce3d2d7',1587306462477,'赵六申请加入',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','5',1587307843155),('a5111d72-a42c-45e0-a7fd-cc775f0c601b',1587306546492,'王八加入申请',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','7',NULL),('a5f824b7-521c-4dd8-a47e-6b81c182d0da',1587306615072,'张四申请',2,'967fbba4-1a3e-49eb-87ab-243e9982ace5','8',1587307873452),('b3f972d4-eb1c-45a9-a23a-7e7b7c508cfa',1587306505661,'田七想加入',0,'2d69c453-e7e4-444d-b806-57147cbc6e34','6',NULL),('b577ac6c-9817-40a6-a789-81b281ea6053',1587306504382,'田七想加入',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','6',NULL),('b6c466c8-b671-4f0d-b67a-aafa1bd449d4',1587306317832,'王五申请加入',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','4',1587307845015),('b8807b83-8d90-4a7f-8dc5-d20cf6668c3b',1587306712371,'赵一的加入申请',0,'82ce95ce-a063-4835-9286-3c9cafea4270','10',NULL),('b943249b-93a1-4d32-8a8c-8ca20d520feb',1587306119000,'李四申请加入王者1队',0,'82ce95ce-a063-4835-9286-3c9cafea4270','3',NULL),('bb75f2df-76f0-4ce8-896d-d39d1f3b05d0',1587306671767,'陈六想加入',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','9',1587308289231),('bbd48934-dd8b-4cc6-8ff9-4e2723eaf53d',1587306620388,'张四申请',0,'a9659f7f-81a2-4239-b4e1-a668408f8cd2','8',NULL),('be22d578-0059-4ec6-b6c0-b914d74dff11',1587306468475,'赵六申请加入',2,'a179c7ce-0937-48f7-a815-faa2c4647cab','5',1587308289894),('c24142db-fae7-4a67-be6b-bd0425f7276c',1587306520348,'田七想加入',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','6',1587308290169),('c6dbd5ef-13ed-4b0d-8133-3156453bea1f',1587306514164,'田七想加入',0,'99738531-a3c7-4378-9feb-7a676a4c69af','6',NULL),('ca2c2dc0-5c03-4c93-8194-b21008aa7af0',1587306562699,'王八加入申请',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','7',1587308290644),('cbcbbbca-8f8f-479d-bdcc-ec3bc12446ac',1587306553414,'王八加入申请',0,'82ce95ce-a063-4835-9286-3c9cafea4270','7',NULL),('cfcbb302-4c11-485e-aa12-a8fb1b7d09f1',1587306720664,'赵一的加入申请',1,'a179c7ce-0937-48f7-a815-faa2c4647cab','10',1587308077922),('d2deff20-ce0d-454a-b858-4de799a7ba9e',1587306663280,'陈六想加入',0,'82ce95ce-a063-4835-9286-3c9cafea4270','9',NULL),('dcfa28a8-ae73-4f7b-99c0-71d37c5f8b94',1587306550772,'王八加入申请',0,'72fd7591-87e5-411f-8b09-08bb34a26bac','7',NULL),('df638f5b-412f-4686-81c9-4477dba6b996',1587307651848,'申请加入',2,'b4af2161-b5fe-4e33-b737-ed8761ea3c02','1',1587307681338),('e03cf7f4-85a4-4949-bdb7-c1c94beacbf2',1587306667419,'陈六想加入',2,'a179c7ce-0937-48f7-a815-faa2c4647cab','9',1587308291868),('e03ea3ea-9112-4cfe-adce-2fa7c55472d6',1587306724725,'赵一的加入申请',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','10',1587308293442),('e0d8de1f-d747-4d3f-aae2-ba2f935027e6',1587306669034,'陈六想加入',0,'a9659f7f-81a2-4239-b4e1-a668408f8cd2','9',NULL),('e7427caf-0afd-46dc-b66a-bc600dc7226c',1587306655116,'陈六想加入',0,'2c19fdd2-a93d-457b-9b0b-764f234af7bc','9',NULL),('eb4378b0-efb7-4f5b-aed3-36a236c2f2af',1587306709973,'赵一的加入申请',0,'72fd7591-87e5-411f-8b09-08bb34a26bac','10',NULL),('f7605ed8-03c5-4544-ab52-e1c1154ddcaf',1587306707874,'赵一的加入申请',2,'4a3644c6-8faa-42d2-86fc-63b1ddb670e3','10',1587307875377),('ffa7e5aa-1c05-4b24-9ed4-76c306b1f22b',1587306325681,'王五申请加入',2,'cd76ac2a-3e0e-4379-994e-435f0eea0ea8','4',1587308294382);

/*Table structure for table `t_college` */

DROP TABLE IF EXISTS `t_college`;

CREATE TABLE `t_college` (
  `college_id` varchar(48) NOT NULL,
  `university_id` varchar(48) DEFAULT NULL,
  `college_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`college_id`),
  KEY `FK_T_COLLEG_REFERENCE_T_UNIVER` (`university_id`),
  CONSTRAINT `FK_T_COLLEG_REFERENCE_T_UNIVER` FOREIGN KEY (`university_id`) REFERENCES `t_university` (`university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_college` */

insert  into `t_college`(`college_id`,`university_id`,`college_name`) values ('1','1','信息工程学院'),('2','1','高博软件学院'),('3','1','艺术设计学院'),('4','1','土木建筑学院'),('5','1','会计与审计学院'),('6','1','管理学院'),('7','1','机电与质量技术工程学院'),('8','1','交通学院'),('9','2','电子科技学院');

/*Table structure for table `t_competition` */

DROP TABLE IF EXISTS `t_competition`;

CREATE TABLE `t_competition` (
  `competition_id` varchar(48) NOT NULL,
  `college_id` varchar(48) DEFAULT NULL,
  `competition_name` varchar(96) DEFAULT NULL,
  `competition_state` int(11) DEFAULT NULL,
  `competition_file` varchar(255) DEFAULT NULL,
  `competition_content` varchar(255) DEFAULT NULL,
  `competition_type` varchar(64) DEFAULT NULL,
  `competition_time` varchar(48) DEFAULT NULL,
  `competition_stoptime` bigint(20) DEFAULT NULL,
  `competition_level` int(11) DEFAULT NULL,
  `competition_site` varchar(64) DEFAULT NULL,
  `competition_people_sum` int(11) DEFAULT NULL,
  PRIMARY KEY (`competition_id`),
  KEY `FK_T_COMPET_REFERENCE_T_COLLEG` (`college_id`),
  CONSTRAINT `FK_T_COMPET_REFERENCE_T_COLLEG` FOREIGN KEY (`college_id`) REFERENCES `t_college` (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_competition` */

insert  into `t_competition`(`competition_id`,`college_id`,`competition_name`,`competition_state`,`competition_file`,`competition_content`,`competition_type`,`competition_time`,`competition_stoptime`,`competition_level`,`competition_site`,`competition_people_sum`) values ('1934a96c-9e6c-4863-b7fc-71e9156b19d5','1','辩论大赛',1,NULL,'辩论大赛','知识竞赛','2020 年 4 月 21 日',NULL,2,'南宁学院',1),('35054ded-b5d5-4b5e-951f-563855042fd6',NULL,'王者荣耀大赛',1,NULL,'王者荣耀大赛需5人组队参加','电子竞技','2020 年 5 月 30 日',NULL,2,'南宁学院',5),('42b487e4-062b-4ca2-8585-925549b5ce87',NULL,'生活知识竞赛',1,NULL,'生活知识考验参赛学生的生活常识','知识竞赛','2020 年 4 月 24 日',NULL,2,'敷文园A101',1),('4d25bdc3-d6e5-4066-a34d-ddd526bcf27d',NULL,'英雄联盟大赛',1,NULL,'英雄联盟大赛','电子竞技','2020 年 6 月 25 日',NULL,2,'南宁学院',5),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','1','计算机组装大赛',1,NULL,'计算机组装大赛，分笔试和机试','科技竞赛','2020 年 5 月 23 日',NULL,1,'南硅谷A501',1),('6c66cd4e-e980-44e4-a36f-fdbfe7552647',NULL,'数学建模大赛',1,NULL,'数学建模大赛主要内容，建模分析，分析文档编写','数学竞赛','2020 年 6 月 17 日',NULL,4,'南宁学院',3),('975af2b6-34f8-448a-b343-f50c87ce2891',NULL,'软件设计大赛',1,NULL,'软件设计大赛软件设计大赛软件设计大赛软件设计大赛软件设计大赛软件设计大赛软件设计大赛','学科竞赛','2020 年 5 月 20 日',NULL,2,'南宁学院',1),('b2005d28-60a1-4387-9e28-7057c1885c70',NULL,'英语口语大赛',1,NULL,'英语口语大赛主要考验学生英语口语能力','知识竞赛','2020 年 6 月 3 日',NULL,2,'敷文园A501',3),('b3aef8ae-0963-40ba-9f7e-769c750e613c',NULL,'羽毛球大赛',1,NULL,'羽毛球大赛','体育竞赛','2020 年 5 月 28 日',NULL,2,'体育馆',1),('b7a13312-c532-4d01-9c16-2caa89491640','1','人工智能大赛',1,NULL,'人工智能大赛人工智能大赛人工智能大赛人工智能大赛','科技竞赛','2020 年 5 月 22 日',NULL,1,'南宁学院',2),('bc141f51-9677-4829-970f-4594540cdf3c',NULL,'创新创业大赛广西区赛',1,NULL,'创新创业大赛广西区赛','创新创业','2020 年 6 月 30 日',NULL,3,'广西大学',1),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8',NULL,'书法大赛',1,NULL,'书法大赛将于最近举行，请大家踊跃报名','知识竞赛','2020 年 6 月 1 日',NULL,2,'南宁学院',1),('eab19a30-3adc-4e74-baa9-bb74ecb558de','1','程序设计大赛',1,NULL,'程序设计大赛，考验编程能力','科技竞赛','2020 年 6 月 25 日',NULL,1,'南硅谷A',1),('f00c96b9-1528-47fe-97c0-505ce8452028',NULL,'英语知识竞赛',1,NULL,'英语知识竞赛','知识竞赛','2020 年 6 月 26 日',NULL,2,'南宁学院',3),('ffe2ef61-69c1-4627-87eb-510948608f0d','1','兵乓球大赛',1,NULL,'兵乓球大赛报名已经开始','体育竞赛','2020 年 4 月 22 日',NULL,2,'体育馆',1);

/*Table structure for table `t_competitiontype` */

DROP TABLE IF EXISTS `t_competitiontype`;

CREATE TABLE `t_competitiontype` (
  `competition_type_id` varchar(48) NOT NULL,
  `competition_type_name` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`competition_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_competitiontype` */

insert  into `t_competitiontype`(`competition_type_id`,`competition_type_name`) values ('1','创新创业'),('2','学科竞赛'),('3','知识竞赛'),('4','体育竞赛'),('5','电子竞技'),('6','数学竞赛'),('7','科技竞赛');

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `file_id` varchar(48) NOT NULL,
  `competition_id` varchar(48) DEFAULT NULL,
  `notification_id` varchar(48) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_T_FILE_REFERENCE_T_COMPET` (`competition_id`),
  KEY `FK_T_FILE_REFERENCE_T_NOTIFI` (`notification_id`),
  CONSTRAINT `FK_T_FILE_REFERENCE_T_COMPET` FOREIGN KEY (`competition_id`) REFERENCES `t_competition` (`competition_id`),
  CONSTRAINT `FK_T_FILE_REFERENCE_T_NOTIFI` FOREIGN KEY (`notification_id`) REFERENCES `t_notification` (`notification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`file_id`,`competition_id`,`notification_id`,`file_name`,`file_path`) values ('03241cb0-44c1-4c13-8d05-b8f377d2dc38','b7a13312-c532-4d01-9c16-2caa89491640',NULL,'Huya.exe','C:\\Users\\Administrator\\Desktop\\file\\notification\\b7a13312-c532-4d01-9c16-2caa89491640\\Huya.exe'),('0d8b4943-7107-4a56-a038-fab418adbf3a',NULL,'732cb93d-f07f-40cb-be23-265388499e7a','系统优化详情.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\732cb93d-f07f-40cb-be23-265388499e7a\\系统优化详情.docx'),('172426a8-d11f-4df5-b647-77cad394f6b8','f00c96b9-1528-47fe-97c0-505ce8452028',NULL,'赛程通知.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\f00c96b9-1528-47fe-97c0-505ce8452028\\赛程通知.docx'),('2ff6625b-7189-47b4-badc-c9f3960c1935','b2005d28-60a1-4387-9e28-7057c1885c70',NULL,'英语口语大赛.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\b2005d28-60a1-4387-9e28-7057c1885c70\\英语口语大赛.docx'),('388c16bd-129f-4203-bf58-668314816aad',NULL,'1db06542-5b24-4028-8ab5-17ab639ba31c','系统使用说明.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\cdb60d6e-2245-4c7f-ad83-cb0709981bf8\\系统使用说明.docx'),('42cd4e56-0c9f-479e-93a3-9871f5a25a86','cdb60d6e-2245-4c7f-ad83-cb0709981bf8',NULL,'书法大赛须知.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\cdb60d6e-2245-4c7f-ad83-cb0709981bf8\\书法大赛须知.docx'),('680cca23-ad42-4416-9aa1-6021b2b1eed5',NULL,'ecab1296-ae54-4d64-8703-a8a03065cea7','新建 Microsoft Word 文档.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\ecab1296-ae54-4d64-8703-a8a03065cea7\\新建 Microsoft Word 文档.docx'),('6d61280f-af1f-48d3-8d84-026204a224be','975af2b6-34f8-448a-b343-f50c87ce2891',NULL,'辩论大赛获奖名单.xlsx','C:\\Users\\Administrator\\Desktop\\file\\notification\\975af2b6-34f8-448a-b343-f50c87ce2891\\辩论大赛获奖名单.xlsx'),('7858f170-a82e-4198-a9c2-7c54586510a3','42b487e4-062b-4ca2-8585-925549b5ce87',NULL,'生活常识题型.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\42b487e4-062b-4ca2-8585-925549b5ce87\\生活常识题型.docx'),('93d4a0ca-d869-4cf0-ad46-fd661393bf09',NULL,'dc158ec2-d9d8-4107-9681-feb01ad25c3b','组队功能使用说明.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\dc158ec2-d9d8-4107-9681-feb01ad25c3b\\组队功能使用说明.docx'),('af598ba1-3ccd-42ea-a45a-59ca0305b932','6c66cd4e-e980-44e4-a36f-fdbfe7552647',NULL,'数学建模大赛参考文档.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\6c66cd4e-e980-44e4-a36f-fdbfe7552647\\数学建模大赛参考文档.docx'),('b605c9be-300c-4e63-8f44-815f7984bbb8',NULL,'d9c63c0d-e330-40d0-bd36-b0e8b5ff8206','辩论大赛获奖名单.xlsx','C:\\Users\\Administrator\\Desktop\\file\\notification\\d9c63c0d-e330-40d0-bd36-b0e8b5ff8206\\辩论大赛获奖名单.xlsx'),('b652033f-adc0-4892-af9b-a5717ce5e9b6','69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2',NULL,'计算机组装大赛题型说明.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2\\计算机组装大赛题型说明.docx'),('b758c31b-cb48-430d-92ae-5934506138ce','1934a96c-9e6c-4863-b7fc-71e9156b19d5',NULL,'辩论大赛内容.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\1934a96c-9e6c-4863-b7fc-71e9156b19d5\\辩论大赛内容.docx'),('cd95bd4d-e233-484f-957c-4b8646cf79a8','ffe2ef61-69c1-4627-87eb-510948608f0d',NULL,'兵乓球大赛文件.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\ffe2ef61-69c1-4627-87eb-510948608f0d\\兵乓球大赛文件.docx'),('ce1ae7d7-3e59-411f-a62b-f9abd76fe633','6c66cd4e-e980-44e4-a36f-fdbfe7552647',NULL,'数学建模大赛须知.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\6c66cd4e-e980-44e4-a36f-fdbfe7552647\\数学建模大赛须知.docx'),('d1cf7e26-a4f0-43ab-8c4d-c66f49f6a0c8','eab19a30-3adc-4e74-baa9-bb74ecb558de',NULL,'程序设计大赛.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\eab19a30-3adc-4e74-baa9-bb74ecb558de\\程序设计大赛.docx'),('e9bcd45d-037d-4eb7-8a38-bc0c44a2bf01','b7a13312-c532-4d01-9c16-2caa89491640',NULL,'新建 Microsoft Word 文档.docx','C:\\Users\\Administrator\\Desktop\\file\\notification\\b7a13312-c532-4d01-9c16-2caa89491640\\新建 Microsoft Word 文档.docx');

/*Table structure for table `t_notification` */

DROP TABLE IF EXISTS `t_notification`;

CREATE TABLE `t_notification` (
  `notification_id` varchar(48) NOT NULL,
  `notification_content` varchar(255) DEFAULT NULL,
  `notification_time` bigint(20) DEFAULT NULL,
  `notification_title` varchar(48) DEFAULT NULL,
  `notification_type` int(11) DEFAULT NULL,
  `notification_state` int(11) DEFAULT NULL,
  `notification_file` varchar(255) DEFAULT NULL,
  `notification_longtime` bigint(20) DEFAULT NULL,
  `competition_id` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_notification` */

insert  into `t_notification`(`notification_id`,`notification_content`,`notification_time`,`notification_title`,`notification_type`,`notification_state`,`notification_file`,`notification_longtime`,`competition_id`) values ('03fc898c-2b22-4a78-b2ee-8f044153d8bc',NULL,1587297781780,'辩论大赛报名通知',0,0,NULL,NULL,'1934a96c-9e6c-4863-b7fc-71e9156b19d5'),('08875eac-80d2-4fdb-9aff-a4ee5c16b847',NULL,1587297627592,'王者荣耀大赛报名通知',0,1,NULL,NULL,'35054ded-b5d5-4b5e-951f-563855042fd6'),('08db0bae-bfcf-4166-aa64-3c95f599dd66',NULL,1587303985951,'生活知识竞赛通知',0,0,NULL,NULL,'42b487e4-062b-4ca2-8585-925549b5ce87'),('1db06542-5b24-4028-8ab5-17ab639ba31c','系统已开放使用，现在可使用新版本的系统，如遇问题请到->个人->投诉建议填写反馈信息，若为系统问题核实后将给予奖励。',1587304404838,'系统开放使用公告',1,NULL,NULL,NULL,NULL),('2d21f209-2cf5-4904-88cc-9d8b784fbf29',NULL,1589002019635,'人工智能大赛即将开始',0,1,NULL,NULL,'b7a13312-c532-4d01-9c16-2caa89491640'),('447b040c-7a05-4e41-be46-022ea5b83377',NULL,1587352521207,'兵乓球大赛获奖名单',2,NULL,NULL,NULL,'ffe2ef61-69c1-4627-87eb-510948608f0d'),('592f5962-f0b3-4871-b3ee-44a4140e1e82',NULL,1587297551250,'计算机组装大赛通知',0,1,NULL,NULL,'69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2'),('5ef42dda-9912-4724-8c60-8a673023f3db',NULL,1587306807115,'英雄联盟大赛报名',0,1,NULL,NULL,'4d25bdc3-d6e5-4066-a34d-ddd526bcf27d'),('732cb93d-f07f-40cb-be23-265388499e7a','系统界面已于2020-04-19 22:04:11完成调整，界面调整并不影响用户使用，现在可使用新版本的系统，如遇问题请到->个人->投诉建议填写反馈信息，若为系统问题核实后将给予奖励。',1587305051260,'系统更新说明',1,NULL,NULL,NULL,NULL),('745760de-31d8-4d89-90c0-15e854b0978c',NULL,1587297376834,'程序设计大赛报名通知',0,1,NULL,NULL,'eab19a30-3adc-4e74-baa9-bb74ecb558de'),('76b9685b-0776-4c63-b342-b2b240fc7a2e',NULL,1587307317325,'英语知识竞赛通知',0,1,NULL,NULL,'f00c96b9-1528-47fe-97c0-505ce8452028'),('8a0fd983-0764-47e6-8d0e-9f01435e9e9b',NULL,1587297452968,'羽毛球大赛报名通知',0,1,NULL,NULL,'b3aef8ae-0963-40ba-9f7e-769c750e613c'),('9b40c0cc-181e-4497-879f-51156511913f',NULL,1587297306716,'数学建模大赛报名通知',0,1,NULL,NULL,'6c66cd4e-e980-44e4-a36f-fdbfe7552647'),('a09ebd24-0f76-44bd-9942-62f6574fdf9c',NULL,1590039041924,'软件设计大赛报名通知',0,1,NULL,NULL,'975af2b6-34f8-448a-b343-f50c87ce2891'),('ad6f3526-daad-4e06-aacd-385b0a57f6c6',NULL,1587296943963,'英语口语大赛报名通知',0,1,NULL,NULL,'b2005d28-60a1-4387-9e28-7057c1885c70'),('b6298017-2768-4bbb-95f3-f6118a7c726a',NULL,1587311360509,'生活大赛获奖名单',2,NULL,NULL,NULL,'42b487e4-062b-4ca2-8585-925549b5ce87'),('bafa1f45-e1b5-4ec4-bff9-db053e64766b',NULL,1587297163228,'兵乓球大赛报名通知',0,0,NULL,NULL,'ffe2ef61-69c1-4627-87eb-510948608f0d'),('ce8a3c9c-12e7-4d90-a001-859fda283459',NULL,1587304242710,'书法大赛报名通知',0,1,NULL,NULL,'cdb60d6e-2245-4c7f-ad83-cb0709981bf8'),('d038d139-bb1f-4caf-89ff-8c5a2763ca0a','系统上线使用出现部分问题，已于 2020年04月19日21点57分59秒 完成维护，可正常使用！如遇问题请到->个人->投诉建议填写反馈信息，若为系统问题核实后将给予奖励。',1587304679178,'系统更新公告',1,NULL,NULL,NULL,NULL),('d489c052-604d-4df1-9800-d3bb27f8f64a',NULL,1587304109555,'创新创业大赛广西区赛报名通知',0,1,NULL,NULL,'bc141f51-9677-4829-970f-4594540cdf3c'),('d9c63c0d-e330-40d0-bd36-b0e8b5ff8206',NULL,1587311865753,'辩论大赛获奖通知',2,NULL,NULL,NULL,'1934a96c-9e6c-4863-b7fc-71e9156b19d5'),('dc158ec2-d9d8-4107-9681-feb01ad25c3b','系统的组队功能已经全面开放，现在已可以进行组队，创建，解散，加入，招募等功能。可前往 我的比赛·队伍 查看，具体操作请下载操作文件进行阅读和查看，如遇问题请到->个人->投诉建议填写反馈信息，若为系统问题核实后将给予奖励。',1587305262252,'组队功能开放',1,NULL,NULL,NULL,NULL),('ecab1296-ae54-4d64-8703-a8a03065cea7',NULL,1588993871246,'计算机组装大赛获奖名单',2,NULL,NULL,NULL,'69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2');

/*Table structure for table `t_promise` */

DROP TABLE IF EXISTS `t_promise`;

CREATE TABLE `t_promise` (
  `promise_id` varchar(48) NOT NULL,
  `promise_name` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`promise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_promise` */

insert  into `t_promise`(`promise_id`,`promise_name`) values ('1','查看'),('2','修改'),('3','发布通知'),('4','报名');

/*Table structure for table `t_promise_role` */

DROP TABLE IF EXISTS `t_promise_role`;

CREATE TABLE `t_promise_role` (
  `role_id` varchar(48) NOT NULL,
  `promise_id` varchar(48) NOT NULL,
  PRIMARY KEY (`role_id`,`promise_id`),
  KEY `FK_T_PROMIS_REFERENCE_T_PROMIS` (`promise_id`),
  CONSTRAINT `FK_T_PROMIS_REFERENCE_T_PROMIS` FOREIGN KEY (`promise_id`) REFERENCES `t_promise` (`promise_id`),
  CONSTRAINT `FK_T_PROMIS_REFERENCE_T_ROLE` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_promise_role` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` varchar(48) NOT NULL,
  `role_name` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_name`) values ('1','管理员'),('2','学生'),('3','教师');

/*Table structure for table `t_team` */

DROP TABLE IF EXISTS `t_team`;

CREATE TABLE `t_team` (
  `team_id` varchar(48) NOT NULL,
  `captain_id` varchar(48) DEFAULT NULL,
  `team_name` varchar(48) DEFAULT NULL,
  `team_state` int(11) DEFAULT NULL,
  `team_headcount` int(11) DEFAULT NULL,
  `competition_id` varchar(48) DEFAULT NULL,
  `team_content` varchar(255) DEFAULT NULL,
  `apply_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  KEY `FK_T_TEAM_REFERENCE_T_USER` (`captain_id`),
  KEY `FK_T_TEAM_REFERENCE_T_COMPETITION` (`competition_id`),
  CONSTRAINT `FK_T_TEAM_REFERENCE_T_COMPETITION` FOREIGN KEY (`competition_id`) REFERENCES `t_competition` (`competition_id`),
  CONSTRAINT `FK_T_TEAM_REFERENCE_T_USER` FOREIGN KEY (`captain_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_team` */

insert  into `t_team`(`team_id`,`captain_id`,`team_name`,`team_state`,`team_headcount`,`competition_id`,`team_content`,`apply_time`) values ('17527ebf-6d41-44ed-869e-bd5650c08efc','6','田七英雄队',1,1,'4d25bdc3-d6e5-4066-a34d-ddd526bcf27d','田七英雄队等待加入',NULL),('1bfc9d8a-7485-4319-85ac-ec074f6366fd','3','test',1,2,'35054ded-b5d5-4b5e-951f-563855042fd6','test',NULL),('2c19fdd2-a93d-457b-9b0b-764f234af7bc','4','王五王者队',1,1,'35054ded-b5d5-4b5e-951f-563855042fd6','王五王者队',NULL),('2d69c453-e7e4-444d-b806-57147cbc6e34','5','口语赵六队',1,1,'b2005d28-60a1-4387-9e28-7057c1885c70','口语赵六队',NULL),('37731a17-b10f-41b4-8600-ad5acf5205df','4','王五口语队',1,1,'b2005d28-60a1-4387-9e28-7057c1885c70','王五口语队',NULL),('4a3644c6-8faa-42d2-86fc-63b1ddb670e3','1','数学建模队',3,3,'6c66cd4e-e980-44e4-a36f-fdbfe7552647','求队友组队参赛',1587307901494),('72fd7591-87e5-411f-8b09-08bb34a26bac','4','王五数模队',1,1,'6c66cd4e-e980-44e4-a36f-fdbfe7552647','王五数模队招人',NULL),('82ce95ce-a063-4835-9286-3c9cafea4270','2','王者1队',1,3,'35054ded-b5d5-4b5e-951f-563855042fd6','等待广大玩家踊跃加入',NULL),('967fbba4-1a3e-49eb-87ab-243e9982ace5','1','口语大队',3,3,'b2005d28-60a1-4387-9e28-7057c1885c70','等待广大学生加入',1587307912691),('99738531-a3c7-4378-9feb-7a676a4c69af','5','数模赵六队',1,2,'6c66cd4e-e980-44e4-a36f-fdbfe7552647','数模赵六队',NULL),('9f71a5d0-e1d3-4027-b542-6b5c2c75eca2','10','赵一英雄联盟队',1,1,'4d25bdc3-d6e5-4066-a34d-ddd526bcf27d','赵一英雄联盟队',NULL),('a179c7ce-0937-48f7-a815-faa2c4647cab','2','数学建模张三队',3,3,'6c66cd4e-e980-44e4-a36f-fdbfe7552647','寻几个数学学霸共同参赛',1587308374182),('a9659f7f-81a2-4239-b4e1-a668408f8cd2','5','王者赵六队',1,2,'35054ded-b5d5-4b5e-951f-563855042fd6','王者赵六队',NULL),('b4af2161-b5fe-4e33-b737-ed8761ea3c02','8','张四联盟',1,1,'4d25bdc3-d6e5-4066-a34d-ddd526bcf27d','张四联盟招人',NULL),('b7996c26-bf12-409f-9347-d190f83f4c8d','9','陈六联盟',1,1,'4d25bdc3-d6e5-4066-a34d-ddd526bcf27d','陈六联盟',NULL),('c6202e86-0c86-4d8c-94b2-b837211badac','5','赵六英语队',1,1,'f00c96b9-1528-47fe-97c0-505ce8452028','赵六英语队等待加入',NULL),('cd76ac2a-3e0e-4379-994e-435f0eea0ea8','2','张三口语队',3,3,'b2005d28-60a1-4387-9e28-7057c1885c70','这位用户很懒，什么都没留下',1587308363446),('d57ea0cf-3079-4dbe-a8c5-3e41f9c4774f','8','张四英语知识队',1,1,'f00c96b9-1528-47fe-97c0-505ce8452028','张四英语知识队',NULL);

/*Table structure for table `t_university` */

DROP TABLE IF EXISTS `t_university`;

CREATE TABLE `t_university` (
  `university_id` varchar(48) NOT NULL,
  `university_name` varchar(20) DEFAULT NULL,
  `university_city` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_university` */

insert  into `t_university`(`university_id`,`university_name`,`university_city`) values ('1','南宁学院','南宁'),('2','河池学院','河池'),('3','南宁职业技术学院','南宁'),('4','桂林电子科技大学','桂林'),('5','广西师范大学','南宁'),('6','贺州学院','贺州'),('7','广西大学','南宁');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` varchar(48) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(24) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `college_id` varchar(48) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `user_className` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_T_USER_REFERENCE_T_COLLEG` (`college_id`),
  CONSTRAINT `FK_T_USER_REFERENCE_T_COLLEG` FOREIGN KEY (`college_id`) REFERENCES `t_college` (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`password`,`name`,`phone`,`email`,`sex`,`period`,`college_id`,`user_role`,`user_className`) values ('1','20160216001','0cc70288dc60ad45a8c1d9fd06b02b15','陈展尚','18877125659','642125256@qq.com','男',2016,'1',NULL,'计科3班'),('10','20160216010','0f12d2cb8ad82b678f425fbe7e56dbac','赵一','19999999999','19999999999@qq.com','男',2019,'1',NULL,'计科3班'),('11','20160216011','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'3',NULL,'计科3班'),('12','20160216100','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'3',NULL,'计科3班'),('13','20160216101','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'4',NULL,'计科3班'),('14','20160216104','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'4',NULL,'会计学1班'),('15','20160216105','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'5',NULL,'会计学1班'),('16','20160216106','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'5',NULL,'计科（高博）4班'),('17','20160216107','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'6',NULL,'会计学2班'),('18','20160216108','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'6',NULL,'计科1班'),('19','20160216109','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'7',NULL,'计科3班'),('2','20160216002','5ef2015edb439cac2bea7c7bb3796eb1','张三','18888888888','18888888888@qq.com','男',2016,'1',NULL,'计科4班'),('20','20160216110','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'7',NULL,'物联3班'),('21','20160216111','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'8',NULL,'通信1班'),('22','20160216122','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'6',NULL,'通信2班'),('23','20160216123','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'8',NULL,'计科（高博）4班'),('24','20160216124','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'5',NULL,'通信1班'),('25','20160216125','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'6',NULL,'物联3班'),('26','20160216126','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'2',NULL,'计科（高博）4班'),('27','20160216127','072e63c29a8e1044a0c959caf9357b63','test','11111111111','11111111111@qq.com','男',2016,'3',NULL,'物联1班'),('3','20160216003','bb3ff4cb46696769ac6d5585cf676dc9','李四','12222222222','12222222222@qq.com','男',2019,'2',NULL,'计科（高博）3班'),('4','20160216004','0bf9692378bc43a627c8f06d8cf0dc3f','王五','13333333333','13333333333@qq.com','女',2017,'1',NULL,'计科2班'),('5','20160216005','462ae56b5f766c9063d9485bab8af2e1','赵六','14444444444','14444444444@qq.com','女',2018,'1',NULL,'计科1班'),('6','20160216006','31a56597d1cfa721c47f06b7aba8537b','田七','15555555555','15555555555@qq.com','女',2018,'1',NULL,'计科3班'),('7','20160216007','56c107fa559c745087bc7761825117cb','王八','16666666666','16666666666@qq.com','女',2018,'1',NULL,'物联3班'),('8','20160216008','43fcbe0f248a5d053bd3d2e25ceed982','张四','17777777777','17777777777@qq.com','女',2017,'2',NULL,'计科（高博）2班'),('9','20160216009','072e63c29a8e1044a0c959caf9357b63','陈六','11111111111','11111111111@qq.com','男',2016,'2',NULL,'计科（高博）4班');

/*Table structure for table `t_user_competition` */

DROP TABLE IF EXISTS `t_user_competition`;

CREATE TABLE `t_user_competition` (
  `competition_id` varchar(48) NOT NULL,
  `user_id` varchar(48) NOT NULL,
  `date` bigint(20) DEFAULT NULL,
  `win_ranking` int(11) DEFAULT NULL,
  `win_level_name` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`competition_id`,`user_id`),
  KEY `FK_T_USER_C_REFERENCE_T_USER` (`user_id`),
  CONSTRAINT `FK_T_USER_C_REFERENCE_T_COMPET` FOREIGN KEY (`competition_id`) REFERENCES `t_competition` (`competition_id`),
  CONSTRAINT `FK_T_USER_C_REFERENCE_T_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_competition` */

insert  into `t_user_competition`(`competition_id`,`user_id`,`date`,`win_ranking`,`win_level_name`) values ('1934a96c-9e6c-4863-b7fc-71e9156b19d5','1',1587305800860,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','2',1587305488688,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','3',1587308408146,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','4',1587308470805,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','5',1587308574019,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','6',1587308756077,NULL,NULL),('1934a96c-9e6c-4863-b7fc-71e9156b19d5','7',1587309156771,NULL,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','1',1589862458717,NULL,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','2',1587305486123,2,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','3',1587308403954,3,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','4',1587308466443,4,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','5',1587308569513,5,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','6',1587308750161,6,NULL),('42b487e4-062b-4ca2-8585-925549b5ce87','7',1587309140383,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','1',1587305805455,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','2',1587305498481,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','3',1587308414668,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','4',1587308475275,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','5',1587308577983,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','6',1587308762816,NULL,NULL),('69c6b52d-3ceb-4b02-86f3-cbe5280c7cb2','7',1587309149779,NULL,NULL),('975af2b6-34f8-448a-b343-f50c87ce2891','1',1590327890247,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','1',1587305812784,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','2',1587305512896,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','4',1587308479905,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','5',1587308584057,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','6',1587308766822,NULL,NULL),('b3aef8ae-0963-40ba-9f7e-769c750e613c','7',1587309166145,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','1',1587305795686,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','2',1587305481595,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','3',1587308400298,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','4',1587308463780,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','5',1587308566815,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','6',1587308747113,NULL,NULL),('bc141f51-9677-4829-970f-4594540cdf3c','7',1587309132267,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','1',1589189029272,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','2',1587305478293,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','3',1587308397556,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','4',1587308461012,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','5',1587308563367,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','6',1587308744586,NULL,NULL),('cdb60d6e-2245-4c7f-ad83-cb0709981bf8','7',1587309129054,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','2',1587305517208,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','3',1587308419866,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','4',1587308483710,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','5',1587308587789,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','6',1587308771386,NULL,NULL),('eab19a30-3adc-4e74-baa9-bb74ecb558de','7',1587309162351,NULL,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','1',1587306051031,1,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','3',1587308424221,2,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','4',1587308487337,3,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','5',1587308591580,4,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','6',1587308779272,NULL,NULL),('ffe2ef61-69c1-4627-87eb-510948608f0d','7',1587309171931,NULL,NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `role_id` varchar(48) NOT NULL,
  `user_id` varchar(48) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK_T_USER_R_REFERENCE_T_USER` (`user_id`),
  CONSTRAINT `FK_T_USER_R_REFERENCE_T_ROLE` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK_T_USER_R_REFERENCE_T_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`role_id`,`user_id`) values ('1','1'),('2','1'),('2','10'),('1','2'),('2','2'),('2','3'),('2','4'),('2','5'),('2','6'),('2','7'),('2','8'),('2','9');

/*Table structure for table `t_user_team` */

DROP TABLE IF EXISTS `t_user_team`;

CREATE TABLE `t_user_team` (
  `user_id` varchar(48) NOT NULL,
  `team_id` varchar(48) NOT NULL,
  PRIMARY KEY (`user_id`,`team_id`),
  KEY `FK_T_USER_T_REFERENCE_T_TEAM` (`team_id`),
  CONSTRAINT `FK_T_USER_T_REFERENCE_T_TEAM` FOREIGN KEY (`team_id`) REFERENCES `t_team` (`team_id`),
  CONSTRAINT `FK_T_USER_T_REFERENCE_T_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_team` */

insert  into `t_user_team`(`user_id`,`team_id`) values ('6','17527ebf-6d41-44ed-869e-bd5650c08efc'),('1','1bfc9d8a-7485-4319-85ac-ec074f6366fd'),('3','1bfc9d8a-7485-4319-85ac-ec074f6366fd'),('4','2c19fdd2-a93d-457b-9b0b-764f234af7bc'),('5','2d69c453-e7e4-444d-b806-57147cbc6e34'),('4','37731a17-b10f-41b4-8600-ad5acf5205df'),('1','4a3644c6-8faa-42d2-86fc-63b1ddb670e3'),('7','4a3644c6-8faa-42d2-86fc-63b1ddb670e3'),('9','4a3644c6-8faa-42d2-86fc-63b1ddb670e3'),('4','72fd7591-87e5-411f-8b09-08bb34a26bac'),('2','82ce95ce-a063-4835-9286-3c9cafea4270'),('5','82ce95ce-a063-4835-9286-3c9cafea4270'),('6','82ce95ce-a063-4835-9286-3c9cafea4270'),('1','967fbba4-1a3e-49eb-87ab-243e9982ace5'),('10','967fbba4-1a3e-49eb-87ab-243e9982ace5'),('7','967fbba4-1a3e-49eb-87ab-243e9982ace5'),('5','99738531-a3c7-4378-9feb-7a676a4c69af'),('9','99738531-a3c7-4378-9feb-7a676a4c69af'),('10','9f71a5d0-e1d3-4027-b542-6b5c2c75eca2'),('10','a179c7ce-0937-48f7-a815-faa2c4647cab'),('2','a179c7ce-0937-48f7-a815-faa2c4647cab'),('6','a179c7ce-0937-48f7-a815-faa2c4647cab'),('5','a9659f7f-81a2-4239-b4e1-a668408f8cd2'),('6','a9659f7f-81a2-4239-b4e1-a668408f8cd2'),('8','b4af2161-b5fe-4e33-b737-ed8761ea3c02'),('9','b7996c26-bf12-409f-9347-d190f83f4c8d'),('5','c6202e86-0c86-4d8c-94b2-b837211badac'),('2','cd76ac2a-3e0e-4379-994e-435f0eea0ea8'),('3','cd76ac2a-3e0e-4379-994e-435f0eea0ea8'),('5','cd76ac2a-3e0e-4379-994e-435f0eea0ea8'),('8','d57ea0cf-3079-4dbe-a8c5-3e41f9c4774f');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
