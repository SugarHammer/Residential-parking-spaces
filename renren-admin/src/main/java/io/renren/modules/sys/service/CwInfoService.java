/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CwInfo;
import io.renren.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;


public interface CwInfoService extends IService<CwInfo> {

	PageUtils queryPage(Map<String, Object> params);
	
}
