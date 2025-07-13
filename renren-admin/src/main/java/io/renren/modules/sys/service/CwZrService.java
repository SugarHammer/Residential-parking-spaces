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
import io.renren.modules.sys.entity.CwSell;
import io.renren.modules.sys.entity.CwZr;

import java.util.Map;


public interface CwZrService extends IService<CwZr> {

	PageUtils queryPage(Map<String, Object> params);
	
}
