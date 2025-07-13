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

@Data
@TableName("cw_inform")
public class CwInform implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String name;
	private String username;
	private Date createTime;
	private String content;
	private String beizhu;

//			`id`  int(11) NULL DEFAULT NULL ,
//`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
//`create_time`  datetime NULL DEFAULT NULL ,
//`content`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
//`beizhu`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL



}
