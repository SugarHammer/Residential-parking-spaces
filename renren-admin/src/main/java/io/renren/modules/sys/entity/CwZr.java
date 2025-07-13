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
@TableName("cw_zr")
public class CwZr implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String cwInfo;
	private String cwUser;
	private String zrjg;
	private String bzrNum;
	private String bzrUsername;
	private String bzrPhone;
	private String cwNum;
	private String bz;
	private String stu;



//			`id`  int(11) NOT NULL AUTO_INCREMENT ,
//            `cw_info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位信息' ,
//			`cw_user`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位用户姓名' ,
//			`zrjg`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转让价格' ,
//			`bzr_num`  int(11) NULL DEFAULT NULL COMMENT '被转让住户编号' ,
//			`bzr_username`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被转让用户姓名' ,
//			`bzr_phone`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号' ,
//			`cw_num`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位编号' ,
//	;



}
