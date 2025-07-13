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
import java.util.Date;

/**
 * 车位信息
 */
@Data
@TableName("cw_jycx")
public class CwJycx implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String ddh;
	private String cwInfo;
	private String money;
	private String zffs;
	private String beizhu;
	private Date jyTime;
	private String beizhu2;

//			`id`  int(11) NOT NULL AUTO_INCREMENT ,
//`    ddh`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号' ,
//			`cw_info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位信息' ,
//			`money`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '金额' ,
//			`zffs`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式' ,
//			`beizhu`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
//			`jy_time`  datetime NULL DEFAULT NULL COMMENT '交易时间' ,
//	;


}
