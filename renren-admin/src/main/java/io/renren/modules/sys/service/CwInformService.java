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
import io.renren.modules.sys.entity.CwInform;

import java.util.Map;


public interface CwInformService extends IService<CwInform> {

	PageUtils queryPage(Map<String, Object> params);
	
}
