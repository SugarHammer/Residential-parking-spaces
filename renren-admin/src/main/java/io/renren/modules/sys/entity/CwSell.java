/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 车位信息
 */
@Data
@TableName("cw_sell")
public class CwSell implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String cwNum;
	private String price;
	private String weizhi;
	private String stu;
	private String phone;
	private String cwType;
	private String zlKssj;
	private String zlJssj;
	private String zlPrice;
	private String cwLx;
	private String bz;


//`price`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格' ,
//			`weizhi`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置' ,
//			`stu`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,状态
//`cw_num`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,车位编号
//`phone`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,手机号
//`cw_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出售 出组' ,
//			`zl_kssj`  datetime NULL DEFAULT NULL COMMENT '租赁开始时间' ,
//			`zl_jssj`  datetime NULL DEFAULT NULL COMMENT '租赁结束时间' ,

}
