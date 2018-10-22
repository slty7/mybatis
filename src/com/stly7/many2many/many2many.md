1.导入sql
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `order_item_` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` int(11) DEFAULT NULL COMMENT '订单主键',
  `pid` int(11) DEFAULT NULL COMMENT '产品主键',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



2.在一对多关系中准备的数据里已经有Product数据里，这里就只准备订单数据和订单项数据：
	1). 插入两个订单
	2). 插入6条订单项数据，建立如下关系
		a 订单1对应产品 1，2，3
		b 订单2对应产品 2，3，4
			INSERT INTO order_ VALUES (1,'code000A');
			INSERT INTO order_ VALUES (2,'code000B');
			INSERT INTO order_item_ VALUES (null, 1, 1, 100);
			INSERT INTO order_item_ VALUES (null, 1, 2, 100);
			INSERT INTO order_item_ VALUES (null, 1, 3, 100);
			INSERT INTO order_item_ VALUES (null, 2, 2, 100);
			INSERT INTO order_item_ VALUES (null, 2, 3, 100);
			INSERT INTO order_item_ VALUES (null, 2, 4, 100);