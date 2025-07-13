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
import io.renren.modules.sys.entity.CwJycx;

import java.util.Map;


public interface CwJycxService extends IService<CwJycx> {

	PageUtils queryPage(Map<String, Object> params);
	
}
